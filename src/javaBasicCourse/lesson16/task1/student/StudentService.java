package javaBasicCourse.lesson16.task1.student;

public class StudentService {

    public static void assignStudentToGroup(String studentName, int index, Group group) {
        Student student = new Student(studentName, group.getGroupName());
        group.getStudentsForGroup()[index] = student;
    }
    public static void showGroup(Group group) {
        System.out.println("Group: " + group.getGroupName());
        for (int i = 0; i < group.getStudentsForGroup().length; i++) {
            System.out.println("Student " + (i+1) + " : " + group.getStudentsForGroup()[i].getName());
        }
        System.out.println("---------------------------------------");
    }

    public static void showStudents(Student[] students) {
        System.out.println("Students list: ");
        for (Student student : students) {
            System.out.print(student.getName() + " [" + student.getGroupName() + "], ");
        }
        System.out.println();
        System.out.println("---------------------------------------");

    }

}
