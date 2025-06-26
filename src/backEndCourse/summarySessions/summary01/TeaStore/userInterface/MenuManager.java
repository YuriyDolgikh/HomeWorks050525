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

    public void mainMenu(){
        boolean isMainMenuActive = true;
        String command;
        while (isMainMenuActive){
            showMainMenu();
            command = UserInputStatic.inputText("Enter the command:").toUpperCase();
            switch (command){
//                case "1" -> showTeaMenu();
//                case "2" -> showManufacturerMenu();
//                case "3" -> showTypeOfTeaMenu();
                case "X" -> isMainMenuActive = false;
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
        System.out.println("Wrong command");
    }

}
