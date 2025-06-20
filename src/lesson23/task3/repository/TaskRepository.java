package lesson23.task3.repository;

import lesson23.task3.model.Task;

import java.util.Arrays;

public class TaskRepository {
    private final Task[] tasks;

    public TaskRepository(int maxSize) {
        this.tasks = new Task[maxSize];
    }

    public boolean addTask(Task task) {
        int currentSize = getCurrentSize();
        if (currentSize != tasks.length) {
            tasks[currentSize] = task;
            return true;
        }
        return false;
    }

    public Task findTaskById(int id) {
        for (Task task : findAllTasks()) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }
    // Поиск задач возможен по части имени - так удобнее
    public Task[] findTasksByTitle(String title) {
        Task[] sourceTasks = findAllTasks();
        int taskCounter = 0;
        for (Task task : sourceTasks) {
            taskCounter = task.getTaskTitle().toLowerCase().contains(title.toLowerCase()) ? taskCounter + 1 : taskCounter;
        }
        Task[] resultTasks = new Task[taskCounter];
        int resultTaskIndex = 0;
        for (Task task : sourceTasks) {
            if (task.getTaskTitle().toLowerCase().contains(title.toLowerCase())) {
                resultTasks[resultTaskIndex++] = task;
            }
        }
        return resultTasks;
    }

    public Task[] findTasksByStatus(boolean status) {
        Task[] sourceTasks = findAllTasks();
        int tasksCounter = 0;
        for (Task task : sourceTasks) {
            tasksCounter = task.getTaskStatus() == status ? tasksCounter + 1 : tasksCounter;
        }
        Task[] resultTasks = new Task[tasksCounter];
        int resultTaskIndex = 0;
        for (Task task : sourceTasks) {
            if (task.getTaskStatus() == status) {
                resultTasks[resultTaskIndex++] = task;
            }
        }
        return resultTasks;
    }

    public boolean updateTaskStatusByTaskId(int taskId, boolean status) {
        Task task = findTaskById(taskId);
        if (task != null) {
            task.setTaskStatus(status);
            return true;
        }
        return false;
    }

    public boolean updateTaskPriorityByTaskId(int taskId, int priority) {
        Task task = findTaskById(taskId);
        if (task != null) {
            task.setTaskPriority(priority);
            return true;
        }
        return false;
    }

    public boolean deleteTaskById(int taskId) {
        int taskIndex = getTaskIndexInArrayByTaskId(taskId);
        int currentSize = getCurrentSize();
        if (taskIndex == -1) {
            return false;
        }
        if (currentSize == 1) {
            tasks[0] = null;
            return true;
        }
        for (int i = taskIndex + 1; i < currentSize; i++) {
            tasks[i-1] = tasks[i];
        }
        tasks[currentSize - 1] = null;
        return true;
    }

    public Task[] findAllTasks() {
        int currentSize = getCurrentSize();
        return Arrays.copyOf(tasks, currentSize);
    }

    public void sortTasksByPriority() {
        int currentSize = getCurrentSize();
        for (int i = 0; i < currentSize - 1; i++) {
            for (int j = i + 1; j < currentSize; j++) {
                if (tasks[i].getTaskPriority() < tasks[j].getTaskPriority()) {
                    Task temp = tasks[i];
                    tasks[i] = tasks[j];
                    tasks[j] = temp;
                    continue;
                }
                if (tasks[i].getTaskPriority() == tasks[j].getTaskPriority()) {
                    if (tasks[i].getTaskTitle().compareToIgnoreCase(tasks[j].getTaskTitle()) > 0) {
                        Task temp = tasks[i];
                        tasks[i] = tasks[j];
                        tasks[j] = temp;
                    }
                }
            }
        }
    }

    private int getCurrentSize() {
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i] == null) {
                return i;
            }
        }
        return tasks.length; // There is no free space
    }

    private int getTaskIndexInArrayByTaskId(int taskId) {
        Task[] sourceTasks = findAllTasks();
        for (int i = 0; i < sourceTasks.length; i++) {
            if (sourceTasks[i].getId() == taskId) {
                return i;
            }
        }
        return -1;  // There is no task in taskArray
    }
}
