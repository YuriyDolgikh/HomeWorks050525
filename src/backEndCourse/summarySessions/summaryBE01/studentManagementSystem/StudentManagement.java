package backEndCourse.summarySessions.summaryBE01.studentManagementSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentManagement {
    private final Map<Integer, Student> students;

    public StudentManagement() {
        this.students = new HashMap<>();
    }

    public void addStudent(Student student) {
        students.put(student.getId(), student);
    }

    public void addGrade(int studentId, String subject, int grade) {
        students.get(studentId).addGrade(subject, grade);
    }

    public Student getStudent(int studentId) {
        return students.get(studentId);
    }

    public double getAverageGrade(int studentId) {
        Student student = students.get(studentId);
        double sum = 0;
        for (Map.Entry<String, Integer> grade : student.getGrades().entrySet()) {
            sum += grade.getValue();
        }
        return sum / student.getGrades().size();
    }
}
