package backEndCourse.vacationTasks.homeTask.optional.task10;

/*
10) Напишите метод, который получает список объектов и функцию проверки,
    и возвращает Optional с первым объектом в списке, который соответствует
    условиям функции проверки.
 */

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class FirstObjectInList {
    public static void main(String[] args) {
        List<String> stringList = List.of("Hello", "World", "Set", "List", "Map", "Java", "Course", "Pascal", "C++");
        System.out.println("Initial list: " + stringList);
        Optional<String> result = findFirstStringWithS(stringList, new StringPredicate());
        if (result.isPresent()) {
            System.out.println("First string with 's' is: " + result.get());
        } else {
            System.out.println("No string with 's' in the list");
        }
    }

    private static Optional<String> findFirstStringWithS(List<String> list, Predicate<String> predicate) {
        for (String str : list) {
            if (predicate.test(str)) {
                return Optional.of(str);
            }
        }
        return Optional.empty();
    }
}
