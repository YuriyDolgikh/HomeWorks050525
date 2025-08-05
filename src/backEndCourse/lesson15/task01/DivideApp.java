package backEndCourse.lesson15.task01;

import utils.UserInputStatic;

public class DivideApp {
    public static void main(String[] args) {
        System.out.println("Division of two numbers");
        System.out.println("Enter two numbers:");
        int numberOne = UserInputStatic.inputInt("Number 1: ");
        int numberTwo = UserInputStatic.inputInt("Number 2: ");
        try {
            if (numberTwo == 0) {
                throw new ArithmeticException("Division by zero");
            }
            System.out.println("Result: " + (double) numberOne / numberTwo);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
