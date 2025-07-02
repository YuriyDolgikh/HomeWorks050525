package javaBasicCourse.lesson10.task03ToDo;

public class Task {
    private String taskName;
    private String description;

    public Task(String taskName, String description) {
        this.taskName = taskName;
        this.description = description;
    }

    public String getTaskName() {
        return taskName;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskName='" + taskName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
