package backEndCourse.vacationTasks.homeTask.optional.task05;

/*
5) Напишите метод, который получает список строк и возвращает
   первую строку в списке, если она существует, или бросает
   исключение NoSuchElementException, используя Optional.
 */

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class StringOrExeptionApp {
    public static void main(String[] args) {
        List<String> list = List.of("Hello", "World", "!");
        String result = getFirstString(list).get();
        System.out.println(result);
    }

    private static Optional<String> getFirstString(List<String> list){
        if(list.isEmpty() || list.getFirst() == null){
            throw new NoSuchElementException("List is empty or first string is null");
        }
        return Optional.of(list.getFirst());
    }
}
