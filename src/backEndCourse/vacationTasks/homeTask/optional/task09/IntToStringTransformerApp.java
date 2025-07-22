package backEndCourse.vacationTasks.homeTask.optional.task09;

/*
9) Напишите метод, который получает HashSet и функцию преобразования,
   и возвращает HashSet, в котором все значения преобразованы с помощью
   функции преобразования, если HashSet не пустой. Если HashSet пустой,
   метод возвращает пустой HashSet.
 */

import java.util.HashSet;
import java.util.Optional;
import java.util.function.Function;

public class IntToStringTransformerApp {

    public static void main(String[] args) {
        HashSet<Integer> numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        Function<Integer, String> intToStr = number -> "Number: " + number;

        Optional<HashSet<String>> transformed = transform(numbers, intToStr);

        transformed.ifPresentOrElse(
                set -> System.out.println("Transformed set: " + set),
                () -> System.out.println("The set is empty")
        );
    }


    public static Optional<HashSet<String>> transform(HashSet<Integer> sourceSet, Function<Integer, String> transformer) {
        if (sourceSet == null || sourceSet.isEmpty()) {
            return Optional.empty();
        }

        HashSet<String> result = new HashSet<>();
        for (Integer number : sourceSet) {
            result.add(transformer.apply(number));
        }

        return Optional.of(result);
    }

}

