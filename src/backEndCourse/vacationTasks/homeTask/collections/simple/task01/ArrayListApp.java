package backEndCourse.vacationTasks.homeTask.collections.simple.task01;

/*
    1 Создать ArrayList из 10 элементов, отсортировать его по возрастанию и вывести на экран.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListApp {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("John", "Maria", "Nicole", "Sophia", "Linda", "Alex", "Emily", "Jessica", "Karen", "Anna"));

        System.out.println("Names list: " + names);
        names.sort(String::compareTo);
        System.out.println("Sorted names list: " + names);
    }
}
