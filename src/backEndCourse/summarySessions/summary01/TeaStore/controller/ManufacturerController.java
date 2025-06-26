package backEndCourse.summarySessions.summary01.TeaStore.controller;

import backEndCourse.summarySessions.summary01.TeaStore.config.ResponseCode;
import backEndCourse.summarySessions.summary01.TeaStore.entity.Manufacturer;
import backEndCourse.summarySessions.summary01.TeaStore.service.ManufacturerService;
import utils.UserInputStatic;

public class ManufacturerController {
    private final ManufacturerService manufacturerService;

    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    public String addManufacturer() {
        int id = UserInputStatic.inputInt("Please enter the manufacturer id: ");
        String name = UserInputStatic.inputText("Please enter the manufacturer name: ");
        String comment = UserInputStatic.inputText("Please enter the comment: ");
        return manufacturerService.add(id, name, comment).getMessage();
    }

    public String getAllManufacturers() {
        StringBuilder sb = new StringBuilder("Manufacturer list:").append(System.lineSeparator());
        Manufacturer[] manufacturers = manufacturerService.getAll();
        if (manufacturers.length == 0) {
            sb.append(ResponseCode.ERR_DB_IS_EMPTY);
        } else {
            for (Manufacturer manufacturer : manufacturers) {
                sb.append(manufacturer.toString()).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    public String getManufacturerById() {
        int id = UserInputStatic.inputInt("Please enter the manufacturer id: ");
        Manufacturer manufacturer = manufacturerService.getById(id);
        if (manufacturer == null) {
            return ResponseCode.ERR_ID_NOT_FOUND.getMessage();
        }
        return manufacturer.toString();
    }

    public String getManufacturerByName() {
        String name = UserInputStatic.inputText("Please enter the manufacturer name: ");
        Manufacturer manufacturer = manufacturerService.getByName(name);
        if (manufacturer == null) {
            return ResponseCode.ERR_NAME_NOT_FOUND.getMessage();
        }
        return manufacturer.toString();
    }

    public String getManufacturerByPartOfComment() {
        String textToFind = UserInputStatic.inputText("Please enter the part of comment to find: ");
        StringBuilder sb = new StringBuilder("Manufacturer by comments list:").append(System.lineSeparator());
        Manufacturer[] manufacturers = manufacturerService.getByPartOfComment(textToFind);
        if (manufacturers.length == 0) {
            sb.append(ResponseCode.ERR_NO_RECORDS_FOUND);
        } else {
            for (Manufacturer manufacturer : manufacturers) {
                sb.append(manufacturer.toString()).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    public String updateManufacturerNameById() {
        int id = UserInputStatic.inputInt("Please enter the manufacturer id: ");
        String name = UserInputStatic.inputText("Please enter the new name: ");
        return manufacturerService.updateNameByID(id, name).getMessage();
    }

    public String updateManufacturerCommentById() {
        int id = UserInputStatic.inputInt("Please enter the manufacturer id: ");
        String comment = UserInputStatic.inputText("Please enter the new comment: ");
        return manufacturerService.updateCommentByID(id, comment).getMessage();
    }

    public String deleteManufacturerById() {
        int id = UserInputStatic.inputInt("Please enter the manufacturer id to delete: ");
        return manufacturerService.deleteById(id).getMessage();
    }

    public String sortManufacturersByName() {
        StringBuilder sb = new StringBuilder("Manufacturer list:").append(System.lineSeparator());
        sb.append(manufacturerService.sortManufacturersByName()).append(System.lineSeparator());
        return sb.toString();
    }

    public String loadManufacturersIntoDB() {
        ResponseCode response = manufacturerService.loadExampleOfManufacturersIntoDB();
        return response.equals(ResponseCode.MSG_OK) ? response.getMessage() : response.getMessage() + "\nNot all manufacturers are loaded";
    }
}
