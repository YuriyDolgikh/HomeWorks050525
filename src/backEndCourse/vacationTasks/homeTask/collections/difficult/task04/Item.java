package backEndCourse.vacationTasks.homeTask.collections.difficult.task04;

public class Item implements Comparable<Item>{
    private String name;
    private Integer priority;

    public Item(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Item => name: " + name + ", priority = " + priority;
    }

    @Override
    public int compareTo(Item o) {
        return priority.compareTo(o.priority);
    }
}
