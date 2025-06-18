package lesson23.task3;

import lesson23.task3.front.TaskManager;
import lesson23.task3.front.UserInterface;
import lesson23.task3.repository.TaskRepository;
import lesson23.task3.service.TaskService;
import utils.UserInputStatic;

public class TaskDemo {
    public static void main(String[] args) {
        int dbSize = UserInputStatic.inputInt("Please enter the number of tasks you want in DB: ");
        TaskRepository taskRepository = new TaskRepository(dbSize);
        TaskService taskService = new TaskService(taskRepository);
        TaskManager taskManager = new TaskManager(taskService);
        UserInterface userInterface = new UserInterface(taskManager);
        userInterface.menu();
    }
}
