package backEndCourse.lesson14.task06;

import java.util.ArrayList;
import java.util.List;

public class PersonApp {
    public static void main(String[] args) {
        List<Person> students = new ArrayList<>();
        students.add(new Person("John", 19, List.of("Java", "Python")));
        students.add(new Person("Maria", 22, List.of("Ruby")));
        students.add(new Person("Nicole", 20, List.of("Java", "C++", "JavaScript")));
        students.add(new Person("Sophia", 25, List.of("Fortran", "C++", "JavaScript")));
        students.add(new Person("Alex", 26, List.of("Java", "C#", "Pascal")));
        students.add(new Person("Helen", 35, List.of("Lisp", "Algol")));

        List<String> uniqSkills = students.stream()
                .filter(student -> student.getAge() > 25)
                .flatMap(student -> student.getSkills().stream())
                .distinct()
                .sorted()
                .toList();

        System.out.println("Skills: " + uniqSkills);
    }
}
