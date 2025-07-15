package backEndCourse.vacationTasks.homeTask.collections.simple.task07;

/*
    7 Создать Stack, добавить в него несколько элементов. Проверить есть ли в коллекции заданный элемент. Если есть, то найти его глубину и вывести на экран.
 */

import java.util.Arrays;
import java.util.Stack;

public class StackApp {
    public static void main(String[] args) {
        Stack<String> names = new Stack<>();
        names.addAll(Arrays.asList("John", "Maria", "Nicole", "Sophia", "Linda", "Alex", "Emily", "Jessica", "Karen", "Anna"));
        System.out.println("Names: " + names);
        String wordToCheck = "Sophia";
        if (names.contains(wordToCheck)) {
            System.out.println("Depth of " + wordToCheck + ": " + names.search(wordToCheck));
        } else {
            System.out.println(wordToCheck + " is not in the stack");
        }
    }
}
