package backEndCourse.vacationTasks.homeTask.collections.difficult.task04;

/*
    4 Создать очередь PriorityQueue и добавить в нее несколько элементов, у которых есть свойства name и priority.
      Затем извлечь элементы из очереди в порядке приоритета и вывести их на консоль.
*/

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueApp {
    public static void main(String[] args) {
        Queue<Item> queue = new PriorityQueue<>();
        queue.offer(new Item("Apple", 10));
        queue.offer(new Item("Banana", 2));
        queue.offer(new Item("Orange", 31));
        queue.offer(new Item("Pear", 24));
        queue.offer(new Item("Grape", 27));
        queue.offer(new Item("Cherry", 37));

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
