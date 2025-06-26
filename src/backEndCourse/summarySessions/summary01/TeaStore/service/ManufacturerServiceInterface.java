package backEndCourse.summarySessions.summary01.TeaStore.service;

import backEndCourse.summarySessions.summary01.TeaStore.config.ResponseCode;
import backEndCourse.summarySessions.summary01.TeaStore.entity.Manufacturer;

public interface ManufacturerServiceInterface {

    void setTeaService(TeaServiceInterface teaService);

    ResponseCode add(int id, String name, String comment);

    Manufacturer[] getAll();

    Manufacturer getById(int id);

    Manufacturer getByName(String name);

    Manufacturer[] getByPartOfComment(String textToFind);

    ResponseCode updateNameByID(int id, String name);

    ResponseCode updateCommentByID(int id, String comment);

    ResponseCode deleteById(int id);

    ResponseCode sortManufacturersByName();

    ResponseCode loadExampleOfManufacturersIntoDB();
}
