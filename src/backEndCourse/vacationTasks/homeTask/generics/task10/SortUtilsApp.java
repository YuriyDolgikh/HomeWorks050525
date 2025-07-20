package backEndCourse.vacationTasks.homeTask.generics.task10;

/*
    10) Напишите метод sortByProperty, который принимает список объектов и
        имя поля, по которому нужно сортировать список. Используйте Generics
        для обеспечения возможности передачи в метод списка объектов любого
        типа и получения значения поля по имени.
*/

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortUtilsApp {
    public static void main(String[] args) throws ReflectiveOperationException {

        List<Student> students = new ArrayList<>();
        students.add(new Student(4, "Jameson", "Group1"));
        students.add(new Student(2, "Gates", "Group2"));
        students.add(new Student(3, "Abraham", "Group3"));
        students.add(new Student(5, "Jackson", "Group2"));

        System.out.println("Source list");
        printList(students);
        System.out.println("Sorting bi Id");
        printList(sortByProperty(students, "Id"));
        System.out.println("Sorting bi Name");
        printList(sortByProperty(students, "Name"));
        System.out.println("Sorting bi Group");
        printList(sortByProperty(students, "Group"));

    }

    private static <E> List<E> sortByProperty(List<E> srcList, String fieldName) throws ReflectiveOperationException{
        String comparatorName = "backEndCourse.vacationTasks.homeTask.generics.task10.ComparatorBy" + fieldName;
        Class<?> clazz = Class.forName(comparatorName);
        Constructor<Comparator<E>> constructor = (Constructor<Comparator<E>>) clazz.getDeclaredConstructor();
        Comparator<E> comparator = constructor.newInstance();
        List<E> resultList = new ArrayList<>(srcList);
        resultList.sort(comparator);
        return resultList;
    }

    private static <E> void printList(List<E> list){
        for(E e: list){
            System.out.println(e);
        }
    }
}
