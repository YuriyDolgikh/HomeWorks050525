package javaBasicCourse.lesson23.task3.front;

import javaBasicCourse.lesson23.task3.configuration.TaskMessages;
import utils.UserInputStatic;

public class UserInterface {
    TaskManager taskManager;

    public UserInterface(TaskManager taskManager) {
        this.taskManager = taskManager;
    }

    public void menu() {
        String userInput = "";
        while (!userInput.equalsIgnoreCase("x")) {
            showMenu();
            showDelimeter();
            userInput = UserInputStatic.inputText("Please enter a command: ").toLowerCase();
            switch (userInput) {
                case "1":
                    System.out.println(taskManager.createTaskFromUserInput());
                    showDelimeter();
                    break;
                case "2":
                    taskManager.printTasks();
                    showDelimeter();
                    break;
                case "3":
                    System.out.println(taskManager.showTaskById());
                    showDelimeter();
                    break;
                case "4":
                    System.out.println(taskManager.showTasksByTitle());
                    showDelimeter();
                    break;
                case "5":
                    System.out.println(taskManager.showTasksByStatus());
                    showDelimeter();
                    break;
                case "6":
                    System.out.println(taskManager.changeTaskStatus());
                    showDelimeter();
                    break;
                case "7":
                    System.out.println(taskManager.changeTaskPriority());
                    showDelimeter();
                    break;
                case "8":
                    System.out.println(taskManager.removeTaskById());
                    showDelimeter();
                    break;
                case "9":
                    System.out.println(taskManager.sortTasks());
                    showDelimeter();
                    break;
                case "0":
                    taskManager.fillDbWithExampleData();
                    showDelimeter();
                    break;
                case "x":
                    System.out.println("Good Bye!");
                    break;
                default:
                    System.out.println(TaskMessages.ERR_WRONG_COMMAND);
            }
        }
    }

    public void showMenu() {
        System.out.println("1. Create task");
        System.out.println("2. Show all tasks");
        System.out.println("3. Show task by id");
        System.out.println("4. Show tasks by title");
        System.out.println("5. Show tasks by status");
        System.out.println("6. Change task status");
        System.out.println("7. Change task priority");
        System.out.println("8. Remove task by id");
        System.out.println("9. Sort tasks");
        System.out.println("0. Fill DB with example data");
        System.out.println("x. Exit");
    }

    public void showDelimeter() {
        System.out.println("-----------------------------------------------------------");
    }
}
