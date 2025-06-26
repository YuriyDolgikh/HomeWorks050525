package backEndCourse.lesson05.students;

import java.util.ArrayList;
import java.util.List;

public class StudentApp {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Linda"));
        students.add(new Student("Maria"));
        students.add(new Student("Nicole"));
        students.add(new Student("Sophia"));
        students.add(new Student("Helen"));
        System.out.println();

        System.out.println("Student list in reverse order:");
        for (int i  =  students.size() - 1; i >= 0; i--) {
            System.out.println(students.get(i));
        }
        System.out.println();
        System.out.println("Remove student by index 2");
        students.remove(2);
        System.out.println();
        System.out.println("Student list in direct order:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
