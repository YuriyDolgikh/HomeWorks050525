package backEndCourse.lesson15.task05;

import utils.UserInputStatic;

import java.util.InputMismatchException;

public class MyExceptionApp {
    public static void main(String[] args) {
        try {
            int number = UserInputStatic.inputInt("Enter the positive number:");
            if (number < 0){
                throw new NegativeNumberException("The number is negative");
            }
            System.out.println("Number = " + number);
        }catch (NegativeNumberException e){
            System.out.println("Error: " + e.getMessage());
        }catch (InputMismatchException e){
            System.out.println("Error: Input is not a number");
        }
    }
}
