package lesson15.task02;

/*
    1.	Создайте массив из 5 случайных целых чисел из интервала [10;99]
    2.	Выведите его на консоль в строку.
    3.	Определите и выведите на экран сообщение о том, является ли массив строго возрастающей последовательностью.
 */

import java.util.Arrays;
import java.util.Random;

public class IncreasingSequenceApp {
    public static void main(String[] args) {
        int[] numArray = new int[5];
        Random random = new Random();
        for (int i = 0; i < numArray.length; i++) {
            numArray[i] = random.nextInt(10,100);
        }
        System.out.println(Arrays.toString(numArray));
        System.out.println("This array is" + (ArrayService.isArrayIncSequence(numArray) ? "" : " not") + " increasing sequence");
    }
}
