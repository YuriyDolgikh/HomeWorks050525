package backEndCourse.vacationTasks.homeTask.generics.task08;

/*
    8) Напишите метод filter, который принимает список объектов и предикат,
       и возвращает список объектов, удовлетворяющих предикату. Используйте
       Generics для обеспечения возможности передачи в метод списка объектов
       любого типа.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FilterApp {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>(List.of(11, -82, -3, 44, 35, -96, 0, 18, 59, -77));
        List<Integer> positiveNumbers = filter(numbers, new IsIntegerPositivPredicate());
        System.out.println("Negative numbers: " + positiveNumbers);

        List<String> strings = new ArrayList<>();
        strings.add("Hello");
        strings.add(null);
        strings.add("Java");
        strings.add(null);
        strings.add(null);
        strings.add("Course");
        strings.add(null);
        List<String> notNullStrings = filter(strings, new IsNotNullPredicate());
        System.out.println("Strings: " + notNullStrings);
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }
}
