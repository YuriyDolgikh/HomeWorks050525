package javaBasicCourse.lesson23.task1;

import utils.UserInputStatic;

public class ArrayService {

    public int[] sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    public int[] createArrayFromUserInput() {
        return new int[UserInputStatic.inputInt("Please enter the size of the array:")];
    }

    public int[] fillArrayFromUserInput(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = UserInputStatic.inputInt("Please enter the value for the element " + i + ":");
        }
        return array;
    }

    public void printArray(int[] array) {
        for (int item : array) {
            System.out.print(item + " ");
        }
    }
}
