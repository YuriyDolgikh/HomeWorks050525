package backEndCourse.summarySessions.summary01.TeaStore.service;

import backEndCourse.summarySessions.summary01.TeaStore.config.StatusCode;
import backEndCourse.summarySessions.summary01.TeaStore.entity.Manufacturer;
import backEndCourse.summarySessions.summary01.TeaStore.repository.ManufacturerRepository;

public class ManufacturerService {
    private final ManufacturerRepository manufacturerRepository;
    private final TeaService teaService;

    public ManufacturerService(ManufacturerRepository manufacturerRepository, TeaService teaService) {
        this.manufacturerRepository = manufacturerRepository;
        this.teaService = teaService;
    }

    public int add(int id, String name, String comment) {

        if (manufacturerRepository.findById(id) != null) {
            return StatusCode.ERR_ID_ALREADY_EXIST;
        }
        if (manufacturerRepository.findByName(name) != null) {
            return StatusCode.ERR_NAME_ALREADY_EXIST;
        }
        if (name == null || comment == null) {
            return StatusCode.ERR_IS_NULL;
        }
        if (name.isBlank() || comment.isBlank()) {
            return StatusCode.ERR_IS_BLANC;
        }
        if (manufacturerRepository.add(new Manufacturer(id, name, comment))) {
            return StatusCode.MSG_OK;
        }else {
            return StatusCode.ERR_NO_FREE_SPACE;
        }
    }

    public Manufacturer[] getAll() {
        return manufacturerRepository.findAll();
    }

    public Manufacturer getById(int id) {
        return manufacturerRepository.findById(id);
    }

    public Manufacturer getByName(String name) {
        return manufacturerRepository.findByName(name);
    }

    public Manufacturer[] getByPartOfComment(String textToFind) {
        return manufacturerRepository.findByPartOfComment(textToFind);
    }

    public int updateNameByID(int id, String name) {
        if (name == null) {
            return StatusCode.ERR_IS_NULL;
        }
        if (name.isBlank()) {
            return StatusCode.ERR_IS_BLANC;
        }
        if (manufacturerRepository.findById(id) == null) {
            return StatusCode.ERR_ID_NOT_FOUND;
        }
        if (manufacturerRepository.findByName(name) != null) {
            return StatusCode.ERR_NAME_ALREADY_EXIST;
        }
        manufacturerRepository.updateNameById(id, name);
        return StatusCode.MSG_OK;
    }

    public int updateCommentByID(int id, String comment) {
        if (comment == null) {
            return StatusCode.ERR_IS_NULL;
        }
        if (comment.isBlank()) {
            return StatusCode.ERR_IS_BLANC;
        }
        if (manufacturerRepository.findById(id) == null) {
            return StatusCode.ERR_ID_NOT_FOUND;
        }
        manufacturerRepository.updateCommentById(id, comment);
        return StatusCode.MSG_OK;
    }

    public int deleteById(int id) {
        Manufacturer itemToDelete = manufacturerRepository.findById(id);
        if (itemToDelete == null) {
            return StatusCode.ERR_ID_NOT_FOUND;
        }
        if (teaService.getByManufacturerName(itemToDelete.getName()).length != 0) {
            return StatusCode.ERR_LINK_TO_OBJECT_EXIST_IN_ANOTHER_DB;
        }
        manufacturerRepository.deleteById(id);
        return StatusCode.MSG_OK;
    }



}
