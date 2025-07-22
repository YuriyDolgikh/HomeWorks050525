package backEndCourse.vacationTasks.homeTask.optional.task07;

/*
7) Напишите метод, который получает значение типа Double и возвращает
   его квадратный корень, если оно не равно null и положительное, или
   бросит исключение IllegalArgumentException, в противном случае,
   используя Optional.
 */

import java.util.Optional;

public class SqrtOrThrowOptionalApp {
    public static void main(String[] args) {
        printResult(228.6144);
        printResult(-15.3);
    }

    private static Optional<Double> sqrtOrThrow(Double number){
        if(number == null || number <= 0){
            throw new IllegalArgumentException("Number is NULL or not a positive number");
        }
        return Optional.of(Math.sqrt(number));
    }

    private static void printResult(Double number){
        Optional<Double> result = sqrtOrThrow(number);
        if(result.isPresent()){
            System.out.println("Sqrt of "+ number + " = " + result.get());
        }
    }
}
