package lesson15.task01;

import java.util.Arrays;
import java.util.Random;

/*
    1.	Создайте массив из 8 случайных целых чисел из интервала [1;50]
    2.	Выведите массив на консоль в строку.
    3.	Замените каждый элемент с нечетным индексом на ноль.
    4.	Снова выведете массив на консоль в отдельной строке.
 */

public class ChangeSomeItemToZeroApp {
    public static void main(String[] args) {
        int[] numArray = new int[8];
        Random random = new Random();
        for (int i = 0; i < numArray.length; i++) {
            numArray[i] = random.nextInt(1,51);
        }
        System.out.println(Arrays.toString(numArray));
        for (int i = 1; i < numArray.length; i+=2) {
            numArray[i] = 0;
        }
        System.out.println(Arrays.toString(numArray));
    }
}
