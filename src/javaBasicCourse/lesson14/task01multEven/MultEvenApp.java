package javaBasicCourse.lesson14.task01multEven;

import utils.UserInputStatic;

public class MultEvenApp {
    public static void main(String[] args) {
        long mult = 1;
        while (true){
            int number = UserInputStatic.inputInt("Input the number: ");
            if (number == 0){
                break;
            } else if (number % 2 == 0) {
                mult *= number;
            }
        }
        System.out.println("Result of multiplication = " + mult);
    }
}
