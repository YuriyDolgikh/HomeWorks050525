package lesson23.task3.service;

import lesson23.task3.configuration.TaskMessages;
import lesson23.task3.model.Task;
import lesson23.task3.repository.TaskRepository;

public class TaskService {
    public TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public String addTask(int taskID, String taskTitle, String taskDescription, int taskPriority, boolean taskStatus) {
        if (taskTitle == null || taskDescription == null || taskTitle.isBlank() || taskPriority < 1 || taskPriority > 9) {
            return TaskMessages.ERR_WRONG_PARAMS;
        }
        if (taskRepository.findTaskById(taskID) != null) {
            return TaskMessages.ERR_TASK_ALREADY_EXIST;
        }
        if (taskRepository.addTask(new Task(taskID, taskTitle, taskDescription, taskPriority, taskStatus))) {
            return TaskMessages.MSG_TASK_ADDED_SUCCESSFULLY;
        }
        return TaskMessages.ERR_NO_FREE_SPACE;
    }

    public Task getTaskById(int taskID) {
        return taskRepository.findTaskById(taskID);
    }

    public Task[] getTasksByTitle(String taskTitle) {
        if (taskTitle == null || taskTitle.isBlank()) {
            return null;
        }
        return taskRepository.findTasksByTitle(taskTitle);
    }

    public Task[] getTasksByStatus(boolean taskStatus) {
        return taskRepository.findTasksByStatus(taskStatus);
    }

    public String updateTaskStatusByTaskId(int taskID, boolean taskStatus) {
       if (taskRepository.updateTaskStatusByTaskId(taskID, taskStatus)) {
           return TaskMessages.MSG_TASK_WAS_UPDATED;
       }
       return TaskMessages.ERR_TASK_ID_DOES_NOT_EXIST;
    }

    public String updateTaskPriorityByTaskId(int taskID, int taskPriority) {
        if(taskPriority < 1 || taskPriority > 9) {
            return TaskMessages.ERR_WRONG_PARAMS;
        }
        if(taskRepository.updateTaskPriorityByTaskId(taskID, taskPriority)){
            return TaskMessages.MSG_TASK_WAS_UPDATED;
        }
        return TaskMessages.ERR_TASK_ID_DOES_NOT_EXIST;
    }

    public String deleteTaskById(int taskID) {
        if(taskRepository.deleteTaskById(taskID)) {
            return TaskMessages.MSG_TASK_WAS_DELETED;
        }
        return TaskMessages.ERR_TASK_ID_DOES_NOT_EXIST;
    }

    public Task[] findAllTasks() {
        return taskRepository.findAllTasks();
    }

    public String sortSourceDatabase(){
        if(taskRepository.findAllTasks().length == 0){
            return TaskMessages.MSG_DB_IS_EMPTY;
        }
        taskRepository.sortTasksByPriority();
        return TaskMessages.MSG_DB_WAS_SORTED;
    }

    public void fillDbWithExampleData(){
        addTask(11, "Do home task", "Every day", 5, false);
        addTask(21, "Go for shopping", "Buy T-Shirt", 2, false);
        addTask(22, "Call my mom", "Ask for the weekend", 4, true);
        addTask(9, "Call my dad", "No comments", 8, false);
        addTask(31, "Dads birthday", "Buy the flowers", 9, true);
        System.out.println(TaskMessages.MSG_DB_WAS_INITIALIZED);
    }

}
