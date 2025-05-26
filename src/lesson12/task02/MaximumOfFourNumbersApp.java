package lesson12.task02;

import java.util.Random;

public class MaximumOfFourNumbersApp {
    public static void main(String[] args) {
        Random random = new Random();
        int number1 = random.nextInt(101);
        int number2 = random.nextInt(101);
        int number3 = random.nextInt(101);
        int number4 = random.nextInt(101);
        System.out.println("Numbers: " + number1 + " " + number2 + " " + number3 + " " + number4);

        int max = number1;

        if (number2 > max){
            max = number2;
        }
        if (number3 > max){
            max = number3;
        }
        if (number4 > max){
            max = number4;
        }

        System.out.println("Max: " + max);
    }
}
