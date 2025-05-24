package lesson10.task02ToDoSimple;

public class ToDoListApp {
    public static void main(String[] args) {
        TaskService taskService = new TaskService();
        Task task1 = taskService.newTask();
        Task task2 = taskService.newTask();
        Task task3 = taskService.newTask();
        System.out.println(task1);
        System.out.println(task2);
        System.out.println(task3);
    }
}
