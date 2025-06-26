package backEndCourse.summarySessions.summary01.TeaStore.service;

import backEndCourse.summarySessions.summary01.TeaStore.config.ResponseCode;
import backEndCourse.summarySessions.summary01.TeaStore.entity.TypeOfTea;

public interface TypeOfTeaServiceInterface {

    void setTeaService(TeaServiceInterface teaService);
    ResponseCode add(int id, String name, String comment);
    TypeOfTea[] getAll();
    TypeOfTea getById(int id);
    TypeOfTea getByName(String name);
    TypeOfTea[] getByPartOfComment(String textToFind);
    ResponseCode updateTypeNameByID(int id, String name);
    ResponseCode updateCommentByID(int id, String comment);
    ResponseCode deleteById(int id);
    ResponseCode sortTypOfTeaByName();
    ResponseCode loadExampleOfTypeOfTeasIntoDB();
}
