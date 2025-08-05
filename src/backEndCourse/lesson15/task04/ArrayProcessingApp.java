package backEndCourse.lesson15.task04;

import utils.UserInputStatic;

import java.util.Random;

public class ArrayProcessingApp {
    public static void main(String[] args) {
        int arrayLength = UserInputStatic.inputInt("Enter the array length:");
        Random random = new Random();
        int[] integers = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            integers[i] = random.nextInt(1000);
        }
        int index = UserInputStatic.inputInt("Enter the index:");
        try {
            System.out.println("The element at index [" + index + "] is " + integers[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Max index = " + (arrayLength - 1));
        }
    }
}
