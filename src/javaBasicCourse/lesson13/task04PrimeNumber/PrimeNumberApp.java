package javaBasicCourse.lesson13.task04PrimeNumber;

import utils.UserInputStatic;

public class PrimeNumberApp {
    public static void main(String[] args) {
        int number = UserInputStatic.inputInt("Input an integer positive number: ");
        boolean isPrimeNumber = true;
        if (number > 3) {
            for (int i = 2; i <= number / 2; i++) {
                if (number % i == 0) {
                    isPrimeNumber = false;
                    break;
                }
            }
        }
        System.out.println("Number " + number + " is" + (isPrimeNumber ? "" : " not") + " a prime number");
        UserInputStatic.close();
    }

}
