package backEndCourse.summarySessions.summary01.TeaStore.service;

import backEndCourse.summarySessions.summary01.TeaStore.config.ResponseCode;
import backEndCourse.summarySessions.summary01.TeaStore.entity.Tea;

public interface TeaServiceInterface {

    void setTypeOfTeaService(TypeOfTeaServiceInterface typeOfTeaService);
    void setManufacturerService(ManufacturerServiceInterface manufacturerService);
    ResponseCode add(int id, int manufacturerId, int typeOfTeaId, String variety);
    Tea[] getAll();
    Tea getById(int id);
    Tea[] getByManufacturerName(String name);
    Tea[] getByTypeName(String name);
    Tea[] getByVariety(String textToFind);
    Tea[] getByManufacturerAndTypeOfTea(String manufacturerName, String typeOfTeaName);
    ResponseCode updateManufacturerById(int id, String manufacturerName);
    ResponseCode updateTypeOfTeaById(int id, String typeOfTeaName);
    ResponseCode updateVarietyById(int id, String variety);
    ResponseCode deleteById(int id);
    ResponseCode sortTeasByManufacturersNameAndTeasName();
    ResponseCode loadExampleOfTeasIntoDB();

//    private ResponseCode initialCheckTeaBeforeUpdate(Tea teaToUpdate, String parameterToUpdate);
}
