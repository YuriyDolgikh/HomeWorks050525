package lesson12.task02;

import java.util.Random;

public class MaximumOfFourNumbersApp {
    public static void main(String[] args) {
        Random random = new Random();
        int number1 = random.nextInt(100) + 1;
        int number2 = random.nextInt(100) + 1;
        int number3 = random.nextInt(100) + 1;
        int number4 = random.nextInt(100) + 1;
        System.out.println("Numbers: " + number1 + " " + number2 + " " + number3 + " " + number4);

        int max;;
        if (number1 > number2 && number1 > number3 && number1 > number4) {
            max = number1;
        } else if (number2 > number1 && number2 > number3 && number2 > number4) {
            max = number2;
        } else if (number3 > number1 && number3 > number2 && number3 > number4) {
            max = number3;
        } else {
            max = number4;
        }
        System.out.println("Max: " + max);
    }
}
