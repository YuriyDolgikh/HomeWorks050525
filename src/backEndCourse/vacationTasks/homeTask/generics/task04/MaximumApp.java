package backEndCourse.vacationTasks.homeTask.generics.task04;

/*
    4) Напишите метод findMax, который принимает массив объектов и возвращает
       наибольший из них. Используйте Generics для обеспечения возможности
       передачи массива объектов любого типа.
*/

import java.util.Arrays;

public class MaximumApp {
    public static void main(String[] args) {
        String[] strArr = {"Hello", "World", "!", "Java", "Course", "Pascal", "C++"};
        System.out.println("Initial array: " + Arrays.toString(strArr));
        System.out.println("Maximum string: " + findMax(strArr));

        Integer[] intArr = {34, 67, 4, 56, 28};
        System.out.println("Initial array: " + Arrays.toString(intArr));
        System.out.println("Maximum integer: " + findMax(intArr));
    }

    private static <T extends Comparable<T>> T findMax(T[] array) {
        if (array.length == 0) {
            return null;
        }
        T maxItem = array[0];
        for (T item : array) {
            if (item.compareTo(maxItem) > 0) {
                maxItem = item;
            }
        }
        return maxItem;
    }
}
