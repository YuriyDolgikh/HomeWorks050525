package backEndCourse.vacationTasks.homeTask.collections.simple.task06;

/*
    Создать PriorityQueue из 10 элементов типа Integer, добавить несколько элементов, извлечь минимальный элемент и вывести на экран.
 */

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueApp {
    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>(Arrays.asList(10, 23, 5, 18, 15, 12, 48, 7, 39, 20));
        System.out.println("Source queue: " + queue);
        queue.offer(9);
        queue.offer(100);
        queue.offer(50);
        System.out.println("Queue after adding: " + queue);
        System.out.println("Minimum element: " + queue.poll());
        System.out.println("Queue after removing: " + queue);
    }
}
