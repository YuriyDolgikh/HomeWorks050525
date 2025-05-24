package lesson10.task03ToDo;

public class Day {
    private int taskId;
    private Task task;

    public Day(int taskId, Task task) {
        this.taskId = taskId;
        this.task = task;
    }

    @Override
    public String toString() {
        return "Day{" +
                "taskId=" + taskId +
                ", task=" + task +
                '}';
    }
}
