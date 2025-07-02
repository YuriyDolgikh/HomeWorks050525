package backEndCourse.lesson07.task2;

/*
    Дан список String.
    Написать метод, который заменяет все элементы, содержащие букву 'a', на "…".
*/

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class StringsReplacer {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("Hello");
        strings.add("World");
        strings.add("Java");
        strings.add("Course");
        strings.add("Pascal");
        strings.add("C++");
        strings.add("Python");
        strings.add("JavaScript");

        System.out.println("Before replace: " + strings);
        System.out.println("After replace: " + replaceContainsAWithDots(strings));
    }

    public static List<String> replaceContainsAWithDots(List<String> strings) {
        ListIterator<String> iterator = strings.listIterator();
        while (iterator.hasNext()) {
            if (iterator.next().contains("a")) {
                iterator.set("...");
            }
        }
        return strings;
    }
}
