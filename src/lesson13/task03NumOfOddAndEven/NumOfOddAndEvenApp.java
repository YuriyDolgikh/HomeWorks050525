package lesson13.task03NumOfOddAndEven;

import utils.UserInputStatic;

public class NumOfOddAndEvenApp {
    public static void main(String[] args) {
        int number = UserInputStatic.inputInt("Input the number: ");
        int quantityOdd = 0;
        int quantityEven = 0;
        for (int i = 1; i <= number; i+=2) {
            quantityOdd++;
            if(i != number) {
                quantityEven++;
            }
        }
        System.out.println("The number of odds = " + quantityOdd);
        System.out.println("The number of evens = " + quantityEven);
        UserInputStatic.close();
    }
}
