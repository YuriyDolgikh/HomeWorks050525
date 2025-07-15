package backEndCourse.vacationTasks.homeTask.collections.simple.task08;

/*
    8 Создать ArrayDeque, добавить в него несколько элементов с каждой стороны, извлечь элементы с одной из сторон и вывести на экран.
 */

import java.util.ArrayDeque;

public class ArrayDequeApp {
    public static void main(String[] args) {
        ArrayDeque<String> names = new ArrayDeque<>();
        names.offerFirst("John");
        names.offerFirst("Smith");
        names.offerFirst("Williams");
        names.offerLast("Gates");
        names.offerLast("Brown");
        names.offerLast("Lloyd");
        System.out.println("Queue: " + names);
        System.out.println("First element: " + names.pollFirst());
        System.out.println("Queue after: " + names);
        System.out.println("Last element: " + names.pollLast());
        System.out.println("Queue after: " + names);
    }
}
