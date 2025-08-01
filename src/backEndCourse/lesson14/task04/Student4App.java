package backEndCourse.lesson14.task04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Student4App {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student("John", 19, 8.3, 2021));
        students.add(new Student("Maria", 22, 3.7, 2020));
        students.add(new Student("Nicole", 20, 6.0, 2021));
        students.add(new Student("Sophia", 18, 4.5, 2023));
        students.add(new Student("Alex", 21, 4.9, 2019));
        students.add(new Student("Helen", 17, 7.2, 2018));
        students.add(new Student("Jane", 23, 9.0, 2025));

        List<Student> filteredStudent = students.stream()
                .sorted((student1, student2) -> student2.getAvgGrade().compareTo(student1.getAvgGrade()))
                .limit(3)
                .sorted(Comparator.comparingInt(Student::getStartYear))
                .toList();

        System.out.println("Students list:");
        for (Student student : filteredStudent) {
            System.out.println(student);
        }
    }
}
