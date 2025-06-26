package backEndCourse.summarySessions.summary01.TeaStore.service;

import backEndCourse.summarySessions.summary01.TeaStore.config.ExampleData;
import backEndCourse.summarySessions.summary01.TeaStore.config.ResponseCode;
import backEndCourse.summarySessions.summary01.TeaStore.entity.Manufacturer;
import backEndCourse.summarySessions.summary01.TeaStore.repository.ManufacturerRepository;

public class ManufacturerService implements ManufacturerServiceInterface {
    private final ManufacturerRepository manufacturerRepository;
    private TeaServiceInterface teaService;

    public ManufacturerService(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public void setTeaService(TeaServiceInterface teaService) {
        this.teaService = teaService;
    }

    @Override
    public ResponseCode add(int id, String name, String comment) {

        if (manufacturerRepository.findById(id) != null) {
            return ResponseCode.ERR_ID_ALREADY_EXIST;
        }
        if (manufacturerRepository.findByName(name) != null) {
            return ResponseCode.ERR_NAME_ALREADY_EXIST;
        }
        if (name == null || comment == null) {
            return ResponseCode.ERR_IS_NULL;
        }
        if (name.isBlank() || comment.isBlank()) {
            return ResponseCode.ERR_IS_BLANC;
        }
        if (manufacturerRepository.add(new Manufacturer(id, name, comment))) {
            return ResponseCode.MSG_OK;
        } else {
            return ResponseCode.ERR_NO_FREE_SPACE;
        }
    }

    @Override
    public Manufacturer[] getAll() {
        return manufacturerRepository.findAll();
    }

    @Override
    public Manufacturer getById(int id) {
        return manufacturerRepository.findById(id);
    }

    @Override
    public Manufacturer getByName(String name) {
        return manufacturerRepository.findByName(name);
    }

    @Override
    public Manufacturer[] getByPartOfComment(String textToFind) {
        return manufacturerRepository.findByPartOfComment(textToFind);
    }

    @Override
    public ResponseCode updateNameByID(int id, String name) {
        if (name == null) {
            return ResponseCode.ERR_IS_NULL;
        }
        if (name.isBlank()) {
            return ResponseCode.ERR_IS_BLANC;
        }
        if (manufacturerRepository.findById(id) == null) {
            return ResponseCode.ERR_ID_NOT_FOUND;
        }
        if (manufacturerRepository.findByName(name) != null) {
            return ResponseCode.ERR_NAME_ALREADY_EXIST;
        }
        manufacturerRepository.updateNameById(id, name);
        return ResponseCode.MSG_OK;
    }

    @Override
    public ResponseCode updateCommentByID(int id, String comment) {
        if (comment == null) {
            return ResponseCode.ERR_IS_NULL;
        }
        if (comment.isBlank()) {
            return ResponseCode.ERR_IS_BLANC;
        }
        if (manufacturerRepository.findById(id) == null) {
            return ResponseCode.ERR_ID_NOT_FOUND;
        }
        manufacturerRepository.updateCommentById(id, comment);
        return ResponseCode.MSG_OK;
    }

    @Override
    public ResponseCode deleteById(int id) {
        Manufacturer itemToDelete = manufacturerRepository.findById(id);
        if (itemToDelete == null) {
            return ResponseCode.ERR_ID_NOT_FOUND;
        }
        if (teaService.getByManufacturerName(itemToDelete.getName()).length != 0) {
            return ResponseCode.ERR_LINK_TO_OBJECT_EXIST_IN_ANOTHER_DB;
        }
        manufacturerRepository.deleteById(id);
        return ResponseCode.MSG_OK;
    }

    @Override
    public ResponseCode sortManufacturersByName() {
        if (manufacturerRepository.findAll().length == 0) {
            return ResponseCode.ERR_DB_IS_EMPTY;
        }
        manufacturerRepository.sortByName();
        return ResponseCode.MSG_OK;
    }

    @Override
    public ResponseCode loadExampleOfManufacturersIntoDB() {
        ResponseCode response = ResponseCode.MSG_OK;
        for (Manufacturer manufacturer : ExampleData.getSimpleManufacturers()) {
            ResponseCode responseCode = add(manufacturer.getId(), manufacturer.getName(), manufacturer.getComment());
            if (!responseCode.equals(ResponseCode.MSG_OK)) {
                response = ResponseCode.ERR_SOMETHING_WENT_WRONG;
            }
        }
        return response;
    }
}
