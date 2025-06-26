package backEndCourse.summarySessions.summary01.TeaStore.userInterface;


import backEndCourse.summarySessions.summary01.TeaStore.controller.ManufacturerController;
import backEndCourse.summarySessions.summary01.TeaStore.controller.TeaController;
import backEndCourse.summarySessions.summary01.TeaStore.controller.TypeOfTeaController;
import utils.UserInputStatic;

public class MenuManager {

    private final TeaController teaController;
    private final ManufacturerController manufacturerController;
    private final TypeOfTeaController typeOfTeaController;

    public MenuManager(TeaController teaController, ManufacturerController manufacturerController, TypeOfTeaController typeOfTeaController) {
        this.teaController = teaController;
        this.manufacturerController = manufacturerController;
        this.typeOfTeaController = typeOfTeaController;
    }

    public void mainMenu() {
        boolean isMainMenuAlive = true;
        String command;
        while (isMainMenuAlive) {
            showMainMenu();
            command = UserInputStatic.inputText("Enter the command:").toUpperCase();
            switch (command) {
                case "1" -> teaMenu();
                case "2" -> manufacturerMenu();
                case "3" -> typeOfTeaMenu();
                case "X" -> isMainMenuAlive = false;
                default -> printWrongCommand();
            }
        }
    }

    public void teaMenu() {
        boolean isTeaMenuAlive = true;
        String command;
        while (isTeaMenuAlive) {
            showTeaMenu();
            command = UserInputStatic.inputText("Enter the command:").toUpperCase();
            switch (command) {
                case "A" -> System.out.println(teaController.addTea());
                case "1" -> System.out.println(teaController.getAllTeas());
                case "2" -> System.out.println(teaController.getTeaById());
                case "3" -> System.out.println(teaController.getTeasByManufacturerName());
                case "4" -> System.out.println(teaController.getTeasByTypeName());
                case "5" -> System.out.println(teaController.getTeaByVariety());
                case "6" -> System.out.println(teaController.getTeasByManufacturerAndTypeOfTea());
                case "7" -> System.out.println(teaController.updateManufacturerById());
                case "8" -> System.out.println(teaController.updateTypeOfTeaById());
                case "9" -> System.out.println(teaController.updateVarietyById());
                case "D" -> System.out.println(teaController.deleteTeaById());
                case "S" -> System.out.println(teaController.sortTea());
                case "L" -> System.out.println(teaController.loadTeaIntoDB());
                case "X" -> isTeaMenuAlive = false;
                default -> printWrongCommand();
            }
        }
    }

    public void manufacturerMenu() {
        boolean isManufacturerMenuAlive = true;
        String command;
        while (isManufacturerMenuAlive) {
            showManufacturerMenu();
            command = UserInputStatic.inputText("Enter the command:").toUpperCase();
            switch (command) {
                case "A" -> System.out.println(manufacturerController.addManufacturer());
                case "1" -> System.out.println(manufacturerController.getAllManufacturers());
                case "2" -> System.out.println(manufacturerController.getManufacturerById());
                case "3" -> System.out.println(manufacturerController.getManufacturerByName());
                case "4" -> System.out.println(manufacturerController.getManufacturerByPartOfComment());
                case "5" -> System.out.println(manufacturerController.updateManufacturerNameById());
                case "6" -> System.out.println(manufacturerController.updateManufacturerCommentById());
                case "D" -> System.out.println(manufacturerController.deleteManufacturerById());
                case "S" -> System.out.println(manufacturerController.sortManufacturersByName());
                case "L" -> System.out.println(manufacturerController.loadManufacturersIntoDB());
                case "X" -> isManufacturerMenuAlive = false;
                default -> printWrongCommand();

            }
        }
    }

    public void typeOfTeaMenu() {
        boolean isTypeOfTeaMenuAlive = true;
        String command;
        while (isTypeOfTeaMenuAlive) {
            showTypeOfTeaMenu();
            command = UserInputStatic.inputText("Enter the command:").toUpperCase();
            switch (command) {
                case "A" -> System.out.println(typeOfTeaController.addTypeOfTea());
                case "1" -> System.out.println(typeOfTeaController.getAllTypeOfTea());
                case "2" -> System.out.println(typeOfTeaController.getTypeOfTeaById());
                case "3" -> System.out.println(typeOfTeaController.getTypeOfTeasByName());
                case "4" -> System.out.println(typeOfTeaController.getTypeOfTeaByPartOfComment());
                case "5" -> System.out.println(typeOfTeaController.updateTypeOfTeaNameById());
                case "6" -> System.out.println(typeOfTeaController.updateTypeOfTeaCommentById());
                case "D" -> System.out.println(typeOfTeaController.deleteTypeOfTeaById());
                case "S" -> System.out.println(typeOfTeaController.sortTypeOfTeasByName());
                case "L" -> System.out.println(typeOfTeaController.loadTypeOfTeasIntoDB());
                case "X" -> isTypeOfTeaMenuAlive = false;
                default -> printWrongCommand();
            }
        }
    }

    private void showMainMenu() {
        System.out.println("--------------------");
        System.out.println("   Main Menu");
        System.out.println("--------------------");
        System.out.println("1. Tea menu");
        System.out.println("2. Manufacturer menu");
        System.out.println("3. Type of tea menu");
        System.out.println("X. Exit");
        System.out.println("--------------------");
    }

    private void showTeaMenu() {
        System.out.println("-----------------------------------");
        System.out.println("   Tea menu");
        System.out.println("-----------------------------------");
        System.out.println("A. Add tea");
        System.out.println("1. Get all teas");
        System.out.println("2. Get tea by ID");
        System.out.println("3. Get tea by manufacturer name");
        System.out.println("4. Get tea by type name");
        System.out.println("5. Get tea by variety");
        System.out.println("6. Get tea by manufacturer and type");
        System.out.println("7. Update manufacturer of tea");
        System.out.println("8. Update type of tea");
        System.out.println("9. Update variety of tea");
        System.out.println("D. Delete tea");
        System.out.println("S. Sort tea database");
        System.out.println("L. Load examples into database");
        System.out.println("X. Exit to Main Menu");
        System.out.println("-----------------------------------");
    }

    private void showManufacturerMenu() {
        System.out.println("-------------------------------");
        System.out.println("   Manufacturer menu");
        System.out.println("-------------------------------");
        System.out.println("A. Add manufacturer");
        System.out.println("1. Get all manufacturers");
        System.out.println("2. Get manufacturer by ID");
        System.out.println("3. Get manufacturer by name");
        System.out.println("4. Get manufacturers by comment");
        System.out.println("5. Update manufacturer name");
        System.out.println("6. Update manufacturer comment");
        System.out.println("D. Delete manufacturer");
        System.out.println("S. Sort manufacturer database");
        System.out.println("L. Load examples into database");
        System.out.println("X. Exit to Main Menu");
        System.out.println("-------------------------------");
    }

    private void showTypeOfTeaMenu() {
        System.out.println("------------------------------");
        System.out.println("   Type of tea menu");
        System.out.println("------------------------------");
        System.out.println("A. Add type");
        System.out.println("1. Get all types");
        System.out.println("2. Get type by ID");
        System.out.println("3. Get type by name");
        System.out.println("4. Get type by comment");
        System.out.println("5. Update type name");
        System.out.println("6. Update type comment");
        System.out.println("D. Delete type");
        System.out.println("S. Sort type database");
        System.out.println("L. Load examples into database");
        System.out.println("X. Exit to Main Menu");
        System.out.println("------------------------------");
    }

    private void printWrongCommand() {
        System.err.println("Wrong command");
    }
}
