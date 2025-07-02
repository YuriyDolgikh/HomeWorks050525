package javaBasicCourse.lesson10.task03ToDo;

public class TodoDaysListApp {
    public static void main(String[] args) {
        TaskService taskService = new TaskService();
        Task task1 = taskService.newTask();
        Task task2 = taskService.newTask();
        Task task3 = taskService.newTask();

        Day daily1 = taskService.createDaysTask(task1);
        Day daily2 = taskService.createDaysTask(task2);
        Day daily3 = taskService.createDaysTask(task3);

        System.out.println(daily1);
        System.out.println(daily2);
        System.out.println(daily3);

    }
}
