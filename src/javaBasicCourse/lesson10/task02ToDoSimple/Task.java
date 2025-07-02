package javaBasicCourse.lesson10.task02ToDoSimple;

public class Task {
    private String taskName;
    private String description;

    public Task(String taskName, String description) {
        this.taskName = taskName;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskName='" + taskName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
