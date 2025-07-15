package backEndCourse.vacationTasks.homeTask.collections.difficult.task08;

/*
    8 Создать множество HashSet и добавить в него несколько строк. Затем создать второе множество и добавить в него
      строки, которые содержат строки из первого множества. Затем вывести на консоль только те строки,
      которые есть в обоих множествах.
*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CrossingSetsApp {
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>(Arrays.asList("Hello", "World", "Java", "Course", "Pascal", "C++"));
        Set<String> set2 = new HashSet<>(Arrays.asList("Java", "Pascal", "C++", "Basic", "JavaScript", "Python"));

        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);

        Set<String> result = new HashSet<>(set1);

        result.retainAll(set2);
        System.out.println("Crossing of Set's: " + result);
    }
}
