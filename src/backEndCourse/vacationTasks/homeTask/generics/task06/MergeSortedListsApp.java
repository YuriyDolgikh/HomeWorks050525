package backEndCourse.vacationTasks.homeTask.generics.task06;

/*
    6) Напишите метод merge, который принимает два отсортированных списка и
       возвращает объединенный отсортированный список. Используйте Generics
       для обеспечения возможности передачи в метод списков любого типа.
*/

import java.util.ArrayList;
import java.util.List;

public class MergeSortedListsApp {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>(List.of("Course", "Hello", "Java", "Pascal", "World"));
        List<String> list2 = new ArrayList<>(List.of("Assembler", "Basic", "C++", "JavaScript", "Python", "Ruby", "Zet"));
        System.out.println("List1: " + list1);
        System.out.println("List2: " + list2);
        System.out.println("Merged list: " + merge(list1, list2));
    }

    private static <T extends Comparable<T>> List<T> merge(List<T> list1, List<T> list2) {
        List<T> resultList = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i).compareTo(list2.get(j)) < 0) {
                resultList.add(list1.get(i++));
            } else {
                resultList.add(list2.get(j++));
            }
        }
        if(i < list1.size()){
            resultList.addAll(list1.subList(i, list1.size()));
        }
        if(j < list2.size()){
            resultList.addAll(list2.subList(j, list2.size()));
        }
        return resultList;
    }
}
