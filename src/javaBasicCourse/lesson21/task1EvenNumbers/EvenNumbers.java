package javaBasicCourse.lesson21.task1EvenNumbers;

public class EvenNumbers {

    public int[] getEvenNumbers(int[] numbers) {
        if(numbers == null) {
            return null;
        }
        int countEven = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                countEven++;
            }
        }
        int evenNumbersIndex = 0;
        int[] evenNumbers = new int[countEven];
        for (int number : numbers) {
            if(number % 2 == 0) {
                evenNumbers[evenNumbersIndex++] = number;
            }
        }
        return evenNumbers;
    }
}
