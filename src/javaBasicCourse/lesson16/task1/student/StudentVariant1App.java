package javaBasicCourse.lesson16.task1.student;

public class StudentVariant1App {
    public static void main(String[] args) {
        Student student1 = new Student("John", "180325-fe");
        Student student2 = new Student("Max", "180325-fe");
        Student student3 = new Student("Jane", "050525-be");
        Student student4 = new Student("Bill", "050525-be");
        Student student5 = new Student("Katy", "180325-fe");
        Student student6 = new Student("Leon", "050525-be");

        Student[] students= {student1, student2, student3, student4, student5, student6};
        StudentService.showStudents(students);

        Student[] studentsArrayForGroup1 = {student1, student2, student5};
        Student[] studentsArrayForGroup2 = {student3, student4, student6};

        Group group1 = new Group("180325-fe", studentsArrayForGroup1);
        Group group2 = new Group("050525-be", studentsArrayForGroup2);
        StudentService.showGroup(group1);
        StudentService.showGroup(group2);
    }
}
