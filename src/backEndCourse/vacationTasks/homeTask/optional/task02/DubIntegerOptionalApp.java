package backEndCourse.vacationTasks.homeTask.optional.task02;

/*
2) Напишите метод, который получает значение типа Integer и
   возвращает его удвоенное значение, если оно не равно null,
   используя Optional.
 */

import java.util.Optional;

public class DubIntegerOptionalApp {
    public static void main(String[] args) {
        printResult(123);
        printResult(null);
    }

    private static Optional<Integer> multiplyInTwo(Integer number){
        if(number == null){
            return Optional.empty();
        }
        return Optional.of(number * 2);
    }

    private static void printResult(Integer number){
        Optional<Integer> result = multiplyInTwo(number);
        if(result.isPresent()){
            System.out.println("Number * 2 = " + result.get());
        }else {
            System.out.println("Number is NULL");
        }
    }
}
