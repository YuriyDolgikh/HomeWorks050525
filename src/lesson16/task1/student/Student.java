package lesson16.task1.student;

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

    public void setName(String name) {
        this.name = name;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
