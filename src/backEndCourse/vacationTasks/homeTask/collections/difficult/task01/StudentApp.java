package backEndCourse.vacationTasks.homeTask.collections.difficult.task01;

/*
        1 Создать класс Student со свойствами name и grade (оценка), затем создать список ArrayList,
        заполнить его несколькими объектами Student и отсортировать список по оценке в порядке убывания.
 */

import java.util.ArrayList;
import java.util.List;

public class StudentApp {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("John", 5));
        students.add(new Student("Maria", 3));
        students.add(new Student("Nicole", 4));
        students.add(new Student("Sophia", 2));
        students.add(new Student("Linda", 1));
        students.add(new Student("Alex", 5));
        students.add(new Student("Emily", 4));
        students.add(new Student("Jessica", 3));
        students.add(new Student("Karen", 1));
        for (Student student : students) {
            System.out.println(student);
        }
        StudentComparator studentComparator = new StudentComparator();
        students.sort(studentComparator);
        System.out.println("Sorted by grade:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
