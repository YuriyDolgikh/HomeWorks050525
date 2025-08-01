package backEndCourse.lesson14.task05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student5App {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Map<Integer, List<Student>> studentsByYear = new HashMap<>();

        students.add(new Student("John", 19, 8.3, 2021));
        students.add(new Student("Maria", 22, 3.7, 2020));
        students.add(new Student("Nicole", 20, 6.0, 2021));
        students.add(new Student("Sophia", 18, 4.5, 2022));
        students.add(new Student("Alex", 21, 4.9, 2020));
        students.add(new Student("Helen", 17, 7.2, 2020));
        students.add(new Student("Jane", 23, 9.0, 2021));

        students.stream().map(student -> student.getStartYear())
                .distinct()
                .forEach(year -> {
                            List<Student> studentsByYearList = students.stream()
                                    .filter(student -> student.getStartYear() == year)
                                    .toList();
                            studentsByYear.put(year, studentsByYearList);
                        }
                );

        System.out.println("Students map by year:");
        for (Map.Entry<Integer, List<Student>> entry : studentsByYear.entrySet()) {
            System.out.println("Year: " + entry.getKey() + ", Students: " + entry.getValue());
        }
    }
}
