package backEndCourse.vacationTasks.homeTask.collections.simple.task10;

/*
    10 Создать HashSet из нескольких элементов, создать LinkedList из тех же элементов и
    вывести на экран элементы LinkedList в том порядке, в котором они были добавлены.
 */

import java.util.HashSet;
import java.util.LinkedList;

public class HashSetAndLinkedListApp {
    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(10);
        hashSet.add(15);
        hashSet.add(20);
        hashSet.add(25);
        hashSet.add(30);
        System.out.println("HashSet: " + hashSet);
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(10);
        linkedList.add(15);
        linkedList.add(20);
        linkedList.add(25);
        linkedList.add(30);
        System.out.println("LinkedList: " + linkedList);
    }
}
