package backEndCourse.vacationTasks.homeTask.collections.simple.task02;

/*
    2 Создать LinkedList из 10 элементов, удалить элементы с индексами, которые хранятся другой коллекции в Set, и вывести на экран, то, что останется от List.
 */

import java.util.*;

public class LinkedListApp {
    public static void main(String[] args) {
        List<String> names = new LinkedList<>(Arrays.asList("John", "Maria", "Nicole", "Sophia", "Linda", "Alex", "Emily", "Jessica", "Karen", "Anna"));
        Set<Integer> indexes = new HashSet<>(Arrays.asList(8, 3, 5, 1, 6));
        System.out.println("Names list: " + names);
        System.out.println("Indexes to remove: " + indexes);
        for (int index : indexes){
            names.set(index, null);
        }
        names.removeIf(Objects::isNull);
        System.out.println("Names list after removing: " + names);
    }
}
