package backEndCourse.vacationTasks.homeTask.optional.task01;

/*
1) Напишите метод, который получает список строк и возвращает
   первую строку в списке, если она существует,
   или пустую строку в противном случае, используя Optional.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StringListOptionalApp {
    public static void main(String[] args) {
        List<String> listEmpty = new ArrayList<>();
        List<String> listNotEmpty = new ArrayList<>();
        listNotEmpty.add("A");
        listNotEmpty.add("B");
        listNotEmpty.add("C");

        System.out.println("Get first element from list empty");
        System.out.println(getFirstStringFromList(listEmpty).get());
        System.out.println("Get first element from list not empty");
        System.out.println(getFirstStringFromList(listNotEmpty).get());

    }

    private static Optional<String> getFirstStringFromList(List<String> list) {
        if (list.isEmpty()) {
            return Optional.of("");
        }
        return Optional.ofNullable(list.getFirst());
    }
}
