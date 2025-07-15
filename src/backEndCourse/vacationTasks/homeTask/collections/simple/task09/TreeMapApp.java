package backEndCourse.vacationTasks.homeTask.collections.simple.task09;

/*
    9 Создать TreeMap, где ключом является число типа Integer, а значением - его факториал. Вывести на экран все элементы TreeMap.
 */

import java.util.TreeMap;

public class TreeMapApp {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 1; i <= 10; i++) {
            treeMap.put(i, factorial(i));
        }
        treeMap.forEach((key, value) -> System.out.println(key + "! = " + value));
    }

    private static Integer factorial(int i) {
        if (i == 1) {
            return 1;
        }
        return i * factorial(i - 1);
    }
}
