package backEndCourse.vacationTasks.homeTask.optional.task06;

/*
6) Напишите метод, который получает значение типа Integer и
   возвращает его удвоенное значение, если оно не равно null,
   или бросает исключение IllegalArgumentException, используя Optional.
 */

import java.util.Optional;

public class DubIntegerOrThrowOptionalApp {
    public static void main(String[] args) {
        printResult(123);
        printResult(null);
    }

    private static Optional<Integer> multiplyInTwoOrThrow(Integer number){
        if(number == null){
            throw new IllegalArgumentException("Number is NULL");
        }
        return Optional.of(number * 2);
    }

    private static void printResult(Integer number){
        Optional<Integer> result = multiplyInTwoOrThrow(number);
        if(result.isPresent()){
            System.out.println("Number * 2 = " + result.get());
        }
    }
}
