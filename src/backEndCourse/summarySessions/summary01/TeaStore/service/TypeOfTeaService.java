package backEndCourse.summarySessions.summary01.TeaStore.service;

import backEndCourse.summarySessions.summary01.TeaStore.config.StatusCode;
import backEndCourse.summarySessions.summary01.TeaStore.entity.TypeOfTea;
import backEndCourse.summarySessions.summary01.TeaStore.repository.TypeOfTeaRepository;

public class TypeOfTeaService {

    private final TypeOfTeaRepository typeOfTeaRepository;
    private final TeaService teaService;

    public TypeOfTeaService(TypeOfTeaRepository typeOfTeaRepository, TeaService teaService) {
        this.typeOfTeaRepository = typeOfTeaRepository;
        this.teaService = teaService;
    }

    public int add(int id, String name, String comment) {

        if (typeOfTeaRepository.findById(id) != null) {
            return StatusCode.ERR_ID_ALREADY_EXIST;
        }
        if (typeOfTeaRepository.findByTypeName(name) != null) {
            return StatusCode.ERR_NAME_ALREADY_EXIST;
        }
        if (name == null || comment == null) {
            return StatusCode.ERR_IS_NULL;
        }
        if (name.isBlank() || comment.isBlank()) {
            return StatusCode.ERR_IS_BLANC;
        }
        if (typeOfTeaRepository.add(new TypeOfTea(id, name, comment))) {
            return StatusCode.MSG_OK;
        }else {
            return StatusCode.ERR_NO_FREE_SPACE;
        }
    }

    public TypeOfTea[] getAll() {
        return typeOfTeaRepository.findAll();
    }

    public TypeOfTea getById(int id) {
        return typeOfTeaRepository.findById(id);
    }

    public TypeOfTea getByName(String name) {
        return typeOfTeaRepository.findByTypeName(name);
    }

    public TypeOfTea[] getByPartOfComment(String textToFind) {
        return typeOfTeaRepository.findByPartOfComment(textToFind);
    }

    public int updateTypeNameByID(int id, String name) {
        if (name == null) {
            return StatusCode.ERR_IS_NULL;
        }
        if (name.isBlank()) {
            return StatusCode.ERR_IS_BLANC;
        }
        if (typeOfTeaRepository.findById(id) == null) {
            return StatusCode.ERR_ID_NOT_FOUND;
        }
        if (typeOfTeaRepository.findByTypeName(name) != null) {
            return StatusCode.ERR_NAME_ALREADY_EXIST;
        }
        typeOfTeaRepository.updateTypeNameById(id, name);
        return StatusCode.MSG_OK;
    }

    public int updateCommentByID(int id, String comment) {
        if (comment == null) {
            return StatusCode.ERR_IS_NULL;
        }
        if (comment.isBlank()) {
            return StatusCode.ERR_IS_BLANC;
        }
        if (typeOfTeaRepository.findById(id) == null) {
            return StatusCode.ERR_ID_NOT_FOUND;
        }
        typeOfTeaRepository.updateCommentById(id, comment);
        return StatusCode.MSG_OK;
    }

    public int deleteById(int id) {
        TypeOfTea itemToDelete = typeOfTeaRepository.findById(id);
        if (itemToDelete == null) {
            return StatusCode.ERR_ID_NOT_FOUND;
        }
        if (teaService.getByTypeName(itemToDelete.getTypeName()).length != 0) {
            return StatusCode.ERR_LINK_TO_OBJECT_EXIST_IN_ANOTHER_DB;
        }
        typeOfTeaRepository.deleteById(id);
        return StatusCode.MSG_OK;
    }



}
