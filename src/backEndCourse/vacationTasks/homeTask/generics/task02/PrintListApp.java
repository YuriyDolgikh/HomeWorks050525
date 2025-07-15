package backEndCourse.vacationTasks.homeTask.generics.task02;

/*
    2) Напишите метод printList, который принимает список объектов и
       выводит их на экран. Используйте Generics для обеспечения
       типобезопасности и возможности передачи списка объектов любого типа.
*/

import java.util.ArrayList;
import java.util.List;

public class PrintListApp {
    public static void main(String[] args) {
        List<String> listStr = new ArrayList<>();
        listStr.add("str1");
        listStr.add("str2");
        listStr.add("str3");
        listStr.add("str4");
        listStr.add("str5");

        printList(listStr);
    }

    private static <E> void printList(List<E> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Item[" + i + "] = " + list.get(i).toString());
        }
    }
}
