package backEndCourse.vacationTasks.homeTask.collections.simple.task03;

/*
    3 Создать HashMap, где ключом является число типа Integer, а значением - его квадрат. Вывести на экран все элементы HashMap.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class HashMapApp {
    public static void main(String[] args) {
        Map<Integer, Integer> squares = new HashMap<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int number = random.nextInt(1, 101);
            if (squares.containsKey(number)) {
                i--;
            } else {
                squares.put(number, number * number);
            }
        }
        for (Map.Entry<Integer, Integer> entry : squares.entrySet()) {
            System.out.println(entry.getKey() + " --> " + entry.getValue());
        }
    }
}
