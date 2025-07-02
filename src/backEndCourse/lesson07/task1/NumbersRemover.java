package backEndCourse.lesson07.task1;

/*
   Дан список целых чисел.
   Написать метод, который удаляет из него все числа больше заданного X.
   В качестве результата выведите измененный список.
*/

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NumbersRemover {
    public static void main(String[] args) {
        List<Integer> numbers = new LinkedList<>(Arrays.asList(1, 42, 34, 10, 62, 15, 2, 78, 24, 51));

        System.out.println("Numbers before removing: " + numbers);
        System.out.println("Numbers after removing: " + removeNumbersMoreThen(numbers, 30));
    }

    private static List<Integer> removeNumbersMoreThen(List<Integer> numbers, Integer num) {
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            Integer number = iterator.next();
            if (number > num) {
                iterator.remove();
            }
        }
        return numbers;
    }
}
