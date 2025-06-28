package backEndCourse.summarySessions.summaryBE01.studentManagementSystem;

public class StudentsApp {
    public static void main(String[] args) {
        StudentManagement studentManagement = new StudentManagement();
        String maths = "Maths";
        String english = "English";
        String history = "History";
        String geography = "Geography";
        String literature = "Literature";

        Student student1 = new Student(1,"Johnson");
        Student student2 = new Student(2,"Smith");
        Student student3 = new Student(3,"Williams");

        studentManagement.addStudent(student1);
        studentManagement.addStudent(student2);
        studentManagement.addStudent(student3);

        studentManagement.addGrade(1, maths, 5);
        studentManagement.addGrade(1, english, 4);
        studentManagement.addGrade(1, history, 3);
        studentManagement.addGrade(1, geography, 5);
        studentManagement.addGrade(1, literature, 4);

        studentManagement.addGrade(2, maths, 4);
        studentManagement.addGrade(2, english, 5);
        studentManagement.addGrade(2, history, 3);
        studentManagement.addGrade(2, geography, 5);

        studentManagement.addGrade(3, maths, 3);
        studentManagement.addGrade(3, english, 5);
        studentManagement.addGrade(3, history, 5);
        studentManagement.addGrade(3, geography, 5);
        studentManagement.addGrade(3, literature, 4);

        System.out.println("Information about student №2:");
        System.out.println(studentManagement.getStudent(2));
        System.out.println("Average score = " + studentManagement.getAverageGrade(2));
    }
}

