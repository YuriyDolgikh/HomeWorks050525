package backEndCourse.summarySessions.summary01.TeaStore.service;

import backEndCourse.summarySessions.summary01.TeaStore.config.InitDataBase;
import backEndCourse.summarySessions.summary01.TeaStore.config.ResponseCode;
import backEndCourse.summarySessions.summary01.TeaStore.entity.Manufacturer;
import backEndCourse.summarySessions.summary01.TeaStore.entity.Tea;
import backEndCourse.summarySessions.summary01.TeaStore.entity.TypeOfTea;
import backEndCourse.summarySessions.summary01.TeaStore.repository.TeaRepository;

public class TeaService {
    private final TeaRepository teaRepository;
    private final TypeOfTeaService typeOfTeaService;
    private final ManufacturerService manufacturerService;

    public TeaService(TeaRepository teaRepository, TypeOfTeaService typeOfTeaService, ManufacturerService manufacturerService) {
        this.teaRepository = teaRepository;
        this.typeOfTeaService = typeOfTeaService;
        this.manufacturerService = manufacturerService;
    }

    public ResponseCode add(int id, int manufacturerId, int typeOfTeaId, String variety) {
        if (teaRepository.findById(id) != null) {
            return ResponseCode.ERR_ID_ALREADY_EXIST;
        }
        Manufacturer manufacturer = manufacturerService.getById(manufacturerId);
        TypeOfTea typeOfTea = typeOfTeaService.getById(typeOfTeaId);
        if (manufacturer == null || typeOfTea == null) {
            return ResponseCode.ERR_ID_NOT_FOUND;
        }
        if (variety == null) {
            return ResponseCode.ERR_IS_NULL;
        }
        if (variety.isBlank()) {
            return ResponseCode.ERR_IS_BLANC;
        }
        Tea tea = new Tea(id, manufacturer, typeOfTea, variety);
        for (Tea item : teaRepository.findAll()) {
            if (item.equals(tea)) {
                return ResponseCode.ERR_OBJECT_ALREADY_EXIST;
            }
        }
        if (teaRepository.add(tea)) {
            return ResponseCode.MSG_OK;
        } else {
            return ResponseCode.ERR_NO_FREE_SPACE;
        }
    }

    public Tea[] getAll() {
        return teaRepository.findAll();
    }

    public Tea getById(int id) {
        return teaRepository.findById(id);
    }

    public Tea[] getByManufacturerName(String name) {
        return teaRepository.findByManufacturer(manufacturerService.getByName(name));
    }

    public Tea[] getByTypeName(String name) {
        return teaRepository.findByTypeOfTea(typeOfTeaService.getByName(name));
    }

    public Tea[] getByVariety(String textToFind) {
        return teaRepository.findByVariety(textToFind);
    }

    public Tea[] getByManufacturerAndTypeOfTea(String manufacturerName, String typeOfTeaName) {
        if (manufacturerName == null || typeOfTeaName == null || manufacturerName.isBlank() || typeOfTeaName.isBlank()) {
            return null;
        }
        return teaRepository.findByManufacturerAndTypeOfTea(manufacturerService.getByName(manufacturerName),
                typeOfTeaService.getByName(typeOfTeaName));
    }

    public ResponseCode updateManufacturerById(int id, String manufacturerName) {
        Tea teaToUpdate = teaRepository.findById(id);
        ResponseCode initCheckStatus = initialCheckTeaBeforeUpdate(teaToUpdate, manufacturerName);
        if(!initCheckStatus.equals(ResponseCode.MSG_OK)){
            return initCheckStatus;
        }
        Manufacturer manufacturerAfterUpdate = manufacturerService.getByName(manufacturerName);
        if (manufacturerAfterUpdate == null) {
            return ResponseCode.ERR_NAME_NOT_FOUND;
        }
        Tea newTeaForCheck = new Tea(0, manufacturerAfterUpdate, teaToUpdate.getType(), teaToUpdate.getVariety());
        for (Tea item : teaRepository.findByManufacturer(manufacturerAfterUpdate)) {
            if (item.equals(newTeaForCheck)) {
                return ResponseCode.ERR_OBJECT_ALREADY_EXIST;
            }
        }
        teaRepository.updateManufacturerById(id, manufacturerAfterUpdate);
        return ResponseCode.MSG_OK;
    }

    public ResponseCode updateTypeOfTeaById(int id, String typeOfTeaName) {
        Tea teaToUpdate = teaRepository.findById(id);
        ResponseCode initCheckStatus = initialCheckTeaBeforeUpdate(teaToUpdate, typeOfTeaName);
        if(!initCheckStatus.equals(ResponseCode.MSG_OK)){
            return initCheckStatus;
        }
        TypeOfTea typeOfTeaAfterUpdate = typeOfTeaService.getByName(typeOfTeaName);
        if (typeOfTeaAfterUpdate == null) {
            return ResponseCode.ERR_NAME_NOT_FOUND;
        }
        Tea newTeaForCheck = new Tea(0, teaToUpdate.getManufacturer(), teaToUpdate.getType(), teaToUpdate.getVariety());
        for (Tea item : teaRepository.findByTypeOfTea(typeOfTeaAfterUpdate)) {
            if (item.equals(newTeaForCheck)) {
                return ResponseCode.ERR_OBJECT_ALREADY_EXIST;
            }
        }
        teaRepository.updateTypeOfTeaById(id, typeOfTeaAfterUpdate);
        return ResponseCode.MSG_OK;
    }

    public ResponseCode updateVarietyById(int id, String variety) {
        Tea teaToUpdate = teaRepository.findById(id);
        ResponseCode initCheckStatus = initialCheckTeaBeforeUpdate(teaToUpdate, variety);
        if(!initCheckStatus.equals(ResponseCode.MSG_OK)){
            return initCheckStatus;
        }
        Tea newTeaForCheck = new Tea(0, teaToUpdate.getManufacturer(), teaToUpdate.getType(), variety);
        for (Tea item : teaRepository.findByVariety(variety)) {
            if (item.equals(newTeaForCheck)) {
                return ResponseCode.ERR_OBJECT_ALREADY_EXIST;
            }
        }
        teaRepository.updateVarietyById(id, variety);
        return ResponseCode.MSG_OK;
    }

    public ResponseCode deleteById(int id) {
        Tea teaToUpdate = teaRepository.findById(id);
        if (teaToUpdate == null) {
            return ResponseCode.ERR_ID_NOT_FOUND;
        }
        if (teaRepository.findAll().length == 0) {
            return ResponseCode.ERR_DB_IS_EMPTY;
        }
        if (teaRepository.deleteById(id)) {
            return ResponseCode.MSG_OK;
        } else {
            return ResponseCode.ERR_SOMETHING_WENT_WRONG;
        }
    }

    public ResponseCode sortTeasByManufacturersNameAndTeasName() {
        if (teaRepository.findAll().length == 0){
            return ResponseCode.ERR_DB_IS_EMPTY;
        }
        teaRepository.sortByManufacturersNameAndTypeOfTeaName();
        return ResponseCode.MSG_OK;
    }

    public ResponseCode loadExampleOfTeasIntoDB() {
        ResponseCode response = ResponseCode.MSG_OK;
        for (Tea tea : InitDataBase.getsimpleTea()){
            ResponseCode responseCode = add(tea.getId(), tea.getManufacturer().getId(), tea.getType().getId(), tea.getVariety());
            if (!responseCode.equals(ResponseCode.MSG_OK)) {
                response = ResponseCode.ERR_SOMETHING_WENT_WRONG;
            }
        }
        return response;
    }

    private ResponseCode initialCheckTeaBeforeUpdate(Tea teaToUpdate, String parameterToUpdate){
        if (teaToUpdate == null) {
            return ResponseCode.ERR_ID_NOT_FOUND;
        }
        if (parameterToUpdate == null) {
            return ResponseCode.ERR_IS_NULL;
        }
        if (parameterToUpdate.isBlank()) {
            return ResponseCode.ERR_IS_BLANC;
        }
        return ResponseCode.MSG_OK;
    }
}
