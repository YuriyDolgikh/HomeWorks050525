package lesson13.task02SumOfEvenNum;

import utils.UserInputStatic;

public class SumOfEvenNumApp {
    public static void main(String[] args) {
        int number = UserInputStatic.inputInt("Input the number: ");
        long sum = 0;
        for (int i = 0; i <= number; i+=2) {
            sum += i;
        }
        System.out.println("The sum of even numbers = " + sum);
        UserInputStatic.close();
    }
}
