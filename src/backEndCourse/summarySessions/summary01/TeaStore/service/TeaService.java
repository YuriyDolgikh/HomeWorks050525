package backEndCourse.summarySessions.summary01.TeaStore.service;

import backEndCourse.summarySessions.summary01.TeaStore.config.StatusCode;
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

    public int add(int id, int manufacturerId, int typeOfTeaId, String variety) {
        if (teaRepository.findById(id) != null) {
            return StatusCode.ERR_ID_ALREADY_EXIST;
        }
        Manufacturer manufacturer = manufacturerService.getById(manufacturerId);
        TypeOfTea typeOfTea = typeOfTeaService.getById(typeOfTeaId);
        if (manufacturer == null || typeOfTea == null) {
            return StatusCode.ERR_ID_NOT_FOUND;
        }
        if (variety == null) {
            return StatusCode.ERR_IS_NULL;
        }
        if (variety.isBlank()) {
            return StatusCode.ERR_IS_BLANC;
        }
        Tea tea = new Tea(id, manufacturer, typeOfTea, variety);
        for (Tea item : teaRepository.findAll()) {
            if (item.equals(tea)) {
                return StatusCode.ERR_OBJECT_ALREADY_EXIST;
            }
        }
        if (teaRepository.add(tea)) {
            return StatusCode.MSG_OK;
        } else {
            return StatusCode.ERR_NO_FREE_SPACE;
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

    public int updateManufacturerById(int id, String manufacturerName) {
        Tea teaToUpdate = teaRepository.findById(id);
        int initCheckStatus = initialCheckTeaBeforeUpdate(teaToUpdate, manufacturerName);
        if(initCheckStatus != StatusCode.MSG_OK){
            return initCheckStatus;
        }

        Manufacturer manufacturerAfterUpdate = manufacturerService.getByName(manufacturerName);
        if (manufacturerAfterUpdate == null) {
            return StatusCode.ERR_NAME_NOT_FOUND;
        }
        Tea newTeaForCheck = new Tea(0, manufacturerAfterUpdate, teaToUpdate.getType(), teaToUpdate.getVariety());
        for (Tea item : teaRepository.findByManufacturer(manufacturerAfterUpdate)) {
            if (item.equals(newTeaForCheck)) {
                return StatusCode.ERR_OBJECT_ALREADY_EXIST;
            }
        }
        teaRepository.updateManufacturerById(id, manufacturerAfterUpdate);
        return StatusCode.MSG_OK;
    }

    public int updateTypeOfTeaById(int id, String typeOfTeaName) {
        Tea teaToUpdate = teaRepository.findById(id);
        int initCheckStatus = initialCheckTeaBeforeUpdate(teaToUpdate, typeOfTeaName);
        if(initCheckStatus != StatusCode.MSG_OK){
            return initCheckStatus;
        }

        TypeOfTea typeOfTeaAfterUpdate = typeOfTeaService.getByName(typeOfTeaName);
        if (typeOfTeaAfterUpdate == null) {
            return StatusCode.ERR_NAME_NOT_FOUND;
        }
        Tea newTeaForCheck = new Tea(0, teaToUpdate.getManufacturer(), teaToUpdate.getType(), teaToUpdate.getVariety());
        for (Tea item : teaRepository.findByTypeOfTea(typeOfTeaAfterUpdate)) {
            if (item.equals(newTeaForCheck)) {
                return StatusCode.ERR_OBJECT_ALREADY_EXIST;
            }
        }
        teaRepository.updateTypeOfTeaById(id, typeOfTeaAfterUpdate);
        return StatusCode.MSG_OK;
    }

    public int updateVarietyById(int id, String variety) {
        Tea teaToUpdate = teaRepository.findById(id);
        int initCheckStatus = initialCheckTeaBeforeUpdate(teaToUpdate, variety);
        if(initCheckStatus != StatusCode.MSG_OK){
            return initCheckStatus;
        }

        Tea newTeaForCheck = new Tea(0, teaToUpdate.getManufacturer(), teaToUpdate.getType(), variety);
        for (Tea item : teaRepository.findByVariety(variety)) {
            if (item.equals(newTeaForCheck)) {
                return StatusCode.ERR_OBJECT_ALREADY_EXIST;
            }
        }
        teaRepository.updateVarietyById(id, variety);
        return StatusCode.MSG_OK;
    }

    public int deleteById(int id) {
        Tea teaToUpdate = teaRepository.findById(id);
        if (teaToUpdate == null) {
            return StatusCode.ERR_ID_NOT_FOUND;
        }
        if (teaRepository.findAll().length == 0) {
            return StatusCode.ERR_DB_IS_EMPTY;
        }
        if (teaRepository.deleteById(id)) {
            return StatusCode.MSG_OK;
        } else {
            return StatusCode.ERR_SOMETHING_WENT_WRONG;
        }
    }

    private int initialCheckTeaBeforeUpdate(Tea teaToUpdate, String parameterToUpdate){
        if (teaToUpdate == null) {
            return StatusCode.ERR_ID_NOT_FOUND;
        }
        if (parameterToUpdate == null) {
            return StatusCode.ERR_IS_NULL;
        }
        if (parameterToUpdate.isBlank()) {
            return StatusCode.ERR_IS_BLANC;
        }
        return StatusCode.MSG_OK;
    }
}
