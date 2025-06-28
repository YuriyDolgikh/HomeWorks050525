package backEndCourse.summarySessions.summaryBE01.studentManagementSystem;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private final int id;
    private final String name;
    private final Map<String, Integer> grades;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.grades = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addGrade(String subject, int grade) {
        grades.put(subject, grade);
    }

    public Map<String, Integer> getGrades() {
        return grades;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grades=" + grades +
                '}';
    }
}
