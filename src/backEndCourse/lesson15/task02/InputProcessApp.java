package backEndCourse.lesson15.task02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputProcessApp {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("Enter your age (only positive integer): ");
                int age = scanner.nextInt();
                if (age <= 0) {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println("The input is not positive integer or not a number!");
                System.out.println("Try again...");
                continue;
            }
            System.out.println("All is OK!");
            break;
        }
    }
}
