package backEndCourse.summarySessions.summary01.TeaStore.controller;

import backEndCourse.summarySessions.summary01.TeaStore.config.ResponseCode;
import backEndCourse.summarySessions.summary01.TeaStore.entity.TypeOfTea;
import backEndCourse.summarySessions.summary01.TeaStore.service.TypeOfTeaService;
import utils.UserInputStatic;

public class TypeOfTeaController {
    private final TypeOfTeaService typeOfTeaService;

    public TypeOfTeaController(TypeOfTeaService typeOfTeaService) {
        this.typeOfTeaService = typeOfTeaService;
    }

    public String addTypeOfTea() {
        int id = UserInputStatic.inputInt("Please enter the type of tea id: ");
        String name = UserInputStatic.inputText("Please enter the type of tea name: ");
        String comment = UserInputStatic.inputText("Please enter the comment: ");
        return typeOfTeaService.add(id, name, comment).getMessage();
    }

    public String getAllTypeOfTea() {
        StringBuilder sb = new StringBuilder("Type of tea list:").append(System.lineSeparator());
        TypeOfTea[] typeOfTeas = typeOfTeaService.getAll();
        if (typeOfTeas.length == 0) {
            sb.append(ResponseCode.ERR_DB_IS_EMPTY);
        } else {
            for (TypeOfTea typeOfTea : typeOfTeas) {
                sb.append(typeOfTea.toString()).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    public String getTypeOfTeaById() {
        int id = UserInputStatic.inputInt("Please enter the type of tea id: ");
        TypeOfTea typeOfTea = typeOfTeaService.getById(id);
        if (typeOfTea == null) {
            return ResponseCode.ERR_ID_NOT_FOUND.getMessage();
        }
        return typeOfTea.toString();
    }

    public String getTypeOfTeasByName() {
        String name = UserInputStatic.inputText("Please enter the type of tea name: ");
        TypeOfTea typeOfTea = typeOfTeaService.getByName(name);
        if (typeOfTea == null) {
            return ResponseCode.ERR_NAME_NOT_FOUND.getMessage();
        }
        return typeOfTea.toString();
    }

    public String getTypeOfTeaByPartOfComment() {
        String textToFind = UserInputStatic.inputText("Please enter the part of comment to find: ");
        StringBuilder sb = new StringBuilder("Type of teas by comments list:").append(System.lineSeparator());
        TypeOfTea[] typeOfTeas = typeOfTeaService.getByPartOfComment(textToFind);
        if (typeOfTeas.length == 0) {
            sb.append(ResponseCode.ERR_NO_RECORDS_FOUND);
        } else {
            for (TypeOfTea typeOfTea : typeOfTeas) {
                sb.append(typeOfTea.toString()).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    public String updateTypeOfTeaNameById() {
        int id = UserInputStatic.inputInt("Please enter the type of tea id: ");
        String name = UserInputStatic.inputText("Please enter the new name: ");
        return typeOfTeaService.updateTypeNameByID(id, name).getMessage();
    }

    public String updateTypeOfTeaCommentById() {
        int id = UserInputStatic.inputInt("Please enter the type of tea id: ");
        String comment = UserInputStatic.inputText("Please enter the new comment: ");
        return typeOfTeaService.updateCommentByID(id, comment).getMessage();
    }

    public String deleteTypeOfTeaById() {
        int id = UserInputStatic.inputInt("Please enter the type of tea id to delete: ");
        return typeOfTeaService.deleteById(id).getMessage();
    }

    public String sortTypeOfTeasByName() {
        StringBuilder sb = new StringBuilder("Types of tea list:").append(System.lineSeparator());
        sb.append(typeOfTeaService.sortTypOfTeaByName()).append(System.lineSeparator());
        return sb.toString();
    }

    public String loadTypeOfTeasIntoDB() {
        ResponseCode response = typeOfTeaService.loadExampleOfTypeOfTeasIntoDB();
        return response.equals(ResponseCode.MSG_OK) ? response.getMessage() : response.getMessage() + "\nNot all types of tea are loaded";
    }
}
