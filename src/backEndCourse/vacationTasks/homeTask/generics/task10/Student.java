package backEndCourse.vacationTasks.homeTask.generics.task10;

import java.util.Objects;

public class Student {
    private final int id;
    private final String name;
    private final String group;

    public Student(int id, String name, String group) {
        this.id = id;
        this.name = name;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Student student)) return false;
        return id == student.id && Objects.equals(name, student.name) && Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, group);
    }

    @Override
    public String toString() {
        return "Student => id: " + id + ", name: " + name + ", group: " + group;
    }
}
