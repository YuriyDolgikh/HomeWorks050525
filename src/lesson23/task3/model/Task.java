package lesson23.task3.model;

import java.util.Objects;

public class Task {
    private int id;
    private String taskTitle;
    private String taskDescription;
    private int taskPriority;   // [0 - 9] 0 = Low, 9 = High
    private boolean taskStatus;    // true - completed, false - active

    public Task(int id, String taskTitle, String taskDescription, int taskPriority, boolean taskStatus) {
        this.id = id;
        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
        this.taskPriority = taskPriority;
        this.taskStatus = taskStatus;
    }

    public int getId() {
        return id;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public int getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(int taskPriority) {
        this.taskPriority = taskPriority;
    }

    public boolean getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(boolean taskStatus) {
        this.taskStatus = taskStatus;
    }

    @Override
    public String toString() {
        return "Task ID= " + id +
                ", Title= " + taskTitle +
                ", Description= " + taskDescription +
                ", Priority=" + taskPriority +
                ", Status= " + (taskStatus ? "Completed" : "Active");
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Task task)) return false;
        return id == task.id && taskPriority == task.taskPriority && taskStatus == task.taskStatus &&
                Objects.equals(taskTitle, task.taskTitle) && Objects.equals(taskDescription, task.taskDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, taskTitle, taskDescription, taskPriority, taskStatus);
    }
}
