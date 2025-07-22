package backEndCourse.vacationTasks.homeTask.optional.task04;

/*
4) Напишите метод, который получает значение типа String и
   возвращает его длину, если оно не равно null, используя Optional.
 */

import java.util.Optional;

public class StringLengthApp {
    public static void main(String[] args) {
        String str = "This is a string";
        Optional<Integer> result = strLengt(str);
        if (result.isPresent()) {
            System.out.println("String length = " + result.get());
        } else  {
            System.out.println("String is NULL");
        }
    }

    private static Optional<Integer> strLengt(String string){
        if(string == null){
            return Optional.empty();
        }
        return Optional.of(string.length());
    }
}
