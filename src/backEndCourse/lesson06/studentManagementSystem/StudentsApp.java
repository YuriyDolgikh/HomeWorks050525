package backEndCourse.lesson06.studentManagementSystem;

import java.util.*;

public class StudentsApp {
    public static void main(String[] args) {

        Map<String, Double> studentsAverageNote = new HashMap<>();

        studentsAverageNote.put("Johnson", 4.5);
        studentsAverageNote.put("Smith", 3.5);
        studentsAverageNote.put("Williams", 4.0);
        studentsAverageNote.put("Jones", 4.1);
        studentsAverageNote.put("Brown", 3.2);

        System.out.println(studentsAverageNote);
        printBestStudent(studentsAverageNote);

        System.out.println("We will change an average grade for the student Brown...");
        studentsAverageNote.put("Brown", 4.9);
        System.out.println(studentsAverageNote);
        printBestStudent(studentsAverageNote);
    }

    private static void printBestStudent(Map<String, Double> studentsAverageNote) {
        double bestAverageGrade = Collections.max(studentsAverageNote.values());
        for (Map.Entry<String, Double> entry : studentsAverageNote.entrySet()) {
            if (entry.getValue() == bestAverageGrade) {
                System.out.println("The best student = " + entry.getKey());
            }
        }
    }
}

