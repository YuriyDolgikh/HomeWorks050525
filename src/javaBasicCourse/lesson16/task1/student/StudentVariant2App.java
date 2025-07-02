package javaBasicCourse.lesson16.task1.student;

public class StudentVariant2App {
    public static void main(String[] args) {
        Group group1 = new Group("180325-fe", new Student[3]);
        Group group2 = new Group("050525-be", new Student[3]);

        StudentService.assignStudentToGroup("John", 0, group1);
        StudentService.assignStudentToGroup("Max",1, group1);
        StudentService.assignStudentToGroup("Jane", 2, group1);

        StudentService.assignStudentToGroup("Bill", 0, group2);
        StudentService.assignStudentToGroup("Katy",1, group2);
        StudentService.assignStudentToGroup("Leon", 2, group2);

        StudentService.showGroup(group1);
        StudentService.showGroup(group2);
    }
}
