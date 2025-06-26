package backEndCourse.lesson05.numbers;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class IntNumberApp {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            list.add(random.nextInt(1, 101));
        }
        System.out.println("Unsorted List:");
        System.out.println(list);
        sortList(list);
        System.out.println("Minimum = " + list.getFirst() +  ", Maximum = " + list.getLast());
        System.out.println("Sorted List:");
        System.out.println(list);
    }

    public static void sortList(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) > list.get(j)) {
                    Collections.swap(list, i, j);
                }
            }
        }
    }
}
