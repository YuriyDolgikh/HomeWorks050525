package javaBasicCourse.lesson16.task1.student;

public class Student {
    private String name;
    private String groupName;

    public Student(String name, String groupName) {
        this.name = name;
        this.groupName = groupName;
    }

    public String getName() {
        return name;
    }

    public String getGroupName() {
        return groupName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
