package backEndCourse.summarySessions.summary01.TeaStore.service;

import backEndCourse.summarySessions.summary01.TeaStore.config.InitDataBase;
import backEndCourse.summarySessions.summary01.TeaStore.config.ResponseCode;
import backEndCourse.summarySessions.summary01.TeaStore.entity.TypeOfTea;
import backEndCourse.summarySessions.summary01.TeaStore.repository.TypeOfTeaRepository;

public class TypeOfTeaService {

    private final TypeOfTeaRepository typeOfTeaRepository;
    private final TeaService teaService;

    public TypeOfTeaService(TypeOfTeaRepository typeOfTeaRepository, TeaService teaService) {
        this.typeOfTeaRepository = typeOfTeaRepository;
        this.teaService = teaService;
    }

    public ResponseCode add(int id, String name, String comment) {

        if (typeOfTeaRepository.findById(id) != null) {
            return ResponseCode.ERR_ID_ALREADY_EXIST;
        }
        if (typeOfTeaRepository.findByTypeName(name) != null) {
            return ResponseCode.ERR_NAME_ALREADY_EXIST;
        }
        if (name == null || comment == null) {
            return ResponseCode.ERR_IS_NULL;
        }
        if (name.isBlank() || comment.isBlank()) {
            return ResponseCode.ERR_IS_BLANC;
        }
        if (typeOfTeaRepository.add(new TypeOfTea(id, name, comment))) {
            return ResponseCode.MSG_OK;
        }else {
            return ResponseCode.ERR_NO_FREE_SPACE;
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

    public ResponseCode updateTypeNameByID(int id, String name) {
        if (name == null) {
            return ResponseCode.ERR_IS_NULL;
        }
        if (name.isBlank()) {
            return ResponseCode.ERR_IS_BLANC;
        }
        if (typeOfTeaRepository.findById(id) == null) {
            return ResponseCode.ERR_ID_NOT_FOUND;
        }
        if (typeOfTeaRepository.findByTypeName(name) != null) {
            return ResponseCode.ERR_NAME_ALREADY_EXIST;
        }
        typeOfTeaRepository.updateTypeNameById(id, name);
        return ResponseCode.MSG_OK;
    }

    public ResponseCode updateCommentByID(int id, String comment) {
        if (comment == null) {
            return ResponseCode.ERR_IS_NULL;
        }
        if (comment.isBlank()) {
            return ResponseCode.ERR_IS_BLANC;
        }
        if (typeOfTeaRepository.findById(id) == null) {
            return ResponseCode.ERR_ID_NOT_FOUND;
        }
        typeOfTeaRepository.updateCommentById(id, comment);
        return ResponseCode.MSG_OK;
    }

    public ResponseCode deleteById(int id) {
        TypeOfTea itemToDelete = typeOfTeaRepository.findById(id);
        if (itemToDelete == null) {
            return ResponseCode.ERR_ID_NOT_FOUND;
        }
        if (teaService.getByTypeName(itemToDelete.getTypeName()).length != 0) {
            return ResponseCode.ERR_LINK_TO_OBJECT_EXIST_IN_ANOTHER_DB;
        }
        typeOfTeaRepository.deleteById(id);
        return ResponseCode.MSG_OK;
    }

    public ResponseCode sortTypOfTeaByName() {
        if (typeOfTeaRepository.findAll().length == 0){
            return ResponseCode.ERR_DB_IS_EMPTY;
        }
        typeOfTeaRepository.sortByName();
        return ResponseCode.MSG_OK;
    }

    public ResponseCode loadExampleOfTypeOfTeasIntoDB() {
        ResponseCode response = ResponseCode.MSG_OK;
        for (TypeOfTea typeOfTea : InitDataBase.getsimpleTypeOfTea()){
            ResponseCode responseCode = add(typeOfTea.getId(), typeOfTea.getTypeName(), typeOfTea.getComment());
            if (!responseCode.equals(ResponseCode.MSG_OK)) {
                response = ResponseCode.ERR_SOMETHING_WENT_WRONG;
            }
        }
        return response;
    }
}
