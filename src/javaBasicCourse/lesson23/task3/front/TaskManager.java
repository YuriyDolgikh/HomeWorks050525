package javaBasicCourse.lesson23.task3.front;

import javaBasicCourse.lesson23.task3.configuration.TaskMessages;
import javaBasicCourse.lesson23.task3.model.Task;
import javaBasicCourse.lesson23.task3.service.TaskService;
import utils.UserInputStatic;

public class TaskManager {
    private TaskService taskService;

    public TaskManager(TaskService taskService) {
        this.taskService = taskService;
    }


    public String createTaskFromUserInput(){
        int id = UserInputStatic.inputInt("Please enter the task id: ");
        String taskTitle = UserInputStatic.inputText("Please enter the task title: ");
        String taskDescription =  UserInputStatic.inputText("Please enter the task description: ");
        int priority = UserInputStatic.inputInt("Please enter the task priority: ");
        boolean status = false;
        return taskService.addTask(id, taskTitle, taskDescription, priority, status);
    }

    public String showTaskById(){
        int id = UserInputStatic.inputInt("Please enter the task id: ");
        Task task = taskService.getTaskById(id);
        if(task == null){
            return TaskMessages.ERR_TASK_ID_DOES_NOT_EXIST;
        }
        return task.toString();
    }

    public String showTasksByTitle(){
        String title = UserInputStatic.inputText("Please enter the task title (may be particular): ");
        Task[] tasks = taskService.getTasksByTitle(title);
        if(title.isBlank()){
            return TaskMessages.ERR_WRONG_PARAMS;
        }
        return getString(tasks);
    }

    public String showTasksByStatus(){
        int statusCode = UserInputStatic.inputInt("What status do you want to view the tasks [1 - completed / 0 - active]: ");
        boolean status;
        if(statusCode == 1){
            status = true;
        }else if(statusCode == 0){
            status = false;
        }else {
            return TaskMessages.ERR_WRONG_PARAMS;
        }
        Task[] tasks = taskService.getTasksByStatus(status);
        return getString(tasks);
    }

    public String changeTaskStatus(){
        int id = UserInputStatic.inputInt("Please enter the task id: ");
        int statusCode = UserInputStatic.inputInt("Please enter the status you want to set for this task [1 - completed / 0 - active]: ");
        boolean status;
        if(statusCode == 1){
            status = true;
        }else if(statusCode == 0){
            status = false;
        }else {
            return TaskMessages.ERR_WRONG_PARAMS;
        }
        return taskService.updateTaskStatusByTaskId(id, status);
    }

    public String changeTaskPriority(){
        int id = UserInputStatic.inputInt("Please enter the task id: ");
        int priority = UserInputStatic.inputInt("Please enter the priority you want to set for this task [1 - 9 (Low - High)]: ");
        return taskService.updateTaskPriorityByTaskId(id, priority);
    }

    public String removeTaskById(){
        int id = UserInputStatic.inputInt("Please enter the task id you want to remove: ");
        return taskService.deleteTaskById(id);
    }

    public void printTasks(){
        Task[] tasks = taskService.findAllTasks();
        if(tasks.length == 0){
            System.out.println(TaskMessages.MSG_DB_IS_EMPTY);
        }else {
            for(Task task : tasks){
                System.out.println(task);
            }
        }
    }

    public String sortTasks(){
        return taskService.sortSourceDatabase();
    }

    private String getString(Task[] tasks) {
        if(tasks.length == 0){
            return TaskMessages.ERR_NO_TASKS_WITH_THIS_PARAMETERS;
        }
        StringBuilder sb = new StringBuilder();
        for(Task task : tasks){
            sb.append(task.toString()).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public void fillDbWithExampleData() {
        taskService.fillDbWithExampleData();
    }
}
