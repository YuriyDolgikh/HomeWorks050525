package backEndCourse.summarySessions.summary01.TeaStore.controller;

import backEndCourse.summarySessions.summary01.TeaStore.config.ResponseCode;
import backEndCourse.summarySessions.summary01.TeaStore.entity.Tea;
import backEndCourse.summarySessions.summary01.TeaStore.service.TeaService;
import utils.UserInputStatic;

public class TeaController {
    private final TeaService teaService;

    public TeaController(TeaService teaService) {
        this.teaService = teaService;
    }

    public String addTea() {
        int id = UserInputStatic.inputInt("Please enter the tea id: ");
        int manufacturerId = UserInputStatic.inputInt("Please enter the manufacturer id: ");
        int typeOfTeaId = UserInputStatic.inputInt("Please enter the type of tea id: ");
        String variety = UserInputStatic.inputText("Please enter the variety: ");
        return teaService.add(id, manufacturerId, typeOfTeaId, variety).getMessage();
    }

    public String getAllTeas() {
        StringBuilder sb = new StringBuilder("Teas list:").append(System.lineSeparator());
        Tea[] teas = teaService.getAll();
        if (teas.length == 0) {
            sb.append(ResponseCode.ERR_DB_IS_EMPTY);
        } else {
            for (Tea tea : teas) {
                sb.append(tea.toString()).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    public String getTeaById() {
        int id = UserInputStatic.inputInt("Please enter the tea id: ");
        Tea tea = teaService.getById(id);
        if (tea == null) {
            return ResponseCode.ERR_ID_NOT_FOUND.getMessage();
        }
        return tea.toString();
    }

    public String getTeasByManufacturerName() {
        String name = UserInputStatic.inputText("Please enter the manufacturer name: ");
        StringBuilder sb = new StringBuilder("Teas by manufacturer list:").append(System.lineSeparator());
        Tea[] teas = teaService.getByManufacturerName(name);
        if (teas.length == 0) {
            sb.append(ResponseCode.ERR_NO_RECORDS_FOUND);
        } else {
            for (Tea tea : teas) {
                sb.append(tea.toString()).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    public String getTeasByTypeName() {
        String typeName = UserInputStatic.inputText("Please enter the type of tea: ");
        StringBuilder sb = new StringBuilder("Teas by type list:").append(System.lineSeparator());
        Tea[] teas = teaService.getByTypeName(typeName);
        if (teas.length == 0) {
            sb.append(ResponseCode.ERR_NO_RECORDS_FOUND);
        } else {
            for (Tea tea : teas) {
                sb.append(tea.toString()).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    public String getTeaByVariety() {
        String textToFind = UserInputStatic.inputText("Please enter the variety: ");
        StringBuilder sb = new StringBuilder("Teas by variety list:").append(System.lineSeparator());
        Tea[] teas = teaService.getByVariety(textToFind);
        if (teas.length == 0) {
            sb.append(ResponseCode.ERR_NO_RECORDS_FOUND);
        } else {
            for (Tea tea : teas) {
                sb.append(tea.toString()).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    public String getTeasByManufacturerAndTypeOfTea() {
        String name = UserInputStatic.inputText("Please enter the manufacturer name: ");
        String typeName = UserInputStatic.inputText("Please enter the type of tea: ");
        StringBuilder sb = new StringBuilder("Teas by manufacturer and type list:").append(System.lineSeparator());
        Tea[] teas = teaService.getByManufacturerAndTypeOfTea(name, typeName);
        if (teas.length == 0) {
            sb.append(ResponseCode.ERR_NO_RECORDS_FOUND);
        } else {
            for (Tea tea : teas) {
                sb.append(tea.toString()).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    public String updateManufacturerById() {
        int id = UserInputStatic.inputInt("Please enter the id of tea to update: ");
        String manufacturerName = UserInputStatic.inputText("Please enter the new manufacturer name: ");
        return teaService.updateManufacturerById(id, manufacturerName).getMessage();
    }

    public String updateTypeOfTeaById() {
        int id = UserInputStatic.inputInt("Please enter the id of tea to update: ");
        String typeOfTeeName = UserInputStatic.inputText("Please enter the new type name: ");
        return teaService.updateTypeOfTeaById(id, typeOfTeeName).getMessage();
    }

    public String updateVarietyById() {
        int id = UserInputStatic.inputInt("Please enter the id of tea to update: ");
        String variety = UserInputStatic.inputText("Please enter the new variety: ");
        return teaService.updateVarietyById(id, variety).getMessage();
    }

    public String deleteTeaById() {
        int id = UserInputStatic.inputInt("Please enter the tea id to delete: ");
        return teaService.deleteById(id).getMessage();
    }

    public String sortTea() {
        StringBuilder sb = new StringBuilder("Tea list:").append(System.lineSeparator());
        sb.append(teaService.sortTeasByManufacturersNameAndTeasName()).append(System.lineSeparator());
        return sb.toString();
    }

    public String loadTeaIntoDB() {
        ResponseCode response = teaService.loadExampleOfTeasIntoDB();
        return response.equals(ResponseCode.MSG_OK) ? response.getMessage() : response.getMessage() + "\nNot all teas are loaded";
    }
}
