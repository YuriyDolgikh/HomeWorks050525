package backEndCourse.lesson14.task01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Student1App {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student("John", 19, 8.3));
        students.add(new Student("Maria", 22, 3.7));
        students.add(new Student("Nicole", 20, 6.0));
        students.add(new Student("Sophia", 18, 4.5));
        students.add(new Student("Alex", 21, 4.9));
        students.add(new Student("Helen", 17, 7.2));
        students.add(new Student("Jane", 23, 9.0));

        List<Student> filteredStudent = students.stream()
                .filter(student -> student.getAvgGrade() > 4.5)
                .sorted(Comparator.comparingInt(student -> student.getAge()))
                .toList();

        System.out.println("Students list:");
        for (Student student : filteredStudent) {
            System.out.println(student);
        }
    }
}
