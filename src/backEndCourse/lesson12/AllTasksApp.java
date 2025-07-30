package backEndCourse.lesson12;

/*
    1. Напишите функциональный интерфейс для преобразования строки в верхний регистр.

    2. Напишите функциональный интерфейс для вычисления суммы двух целых чисел.

    3. Напишите функциональный интерфейс для проверки, является ли строка палиндромом.

    4. Напишите функциональный интерфейс для вычисления факториала числа.

    5. Напишите функциональный интерфейс для проверки, является ли число простым.

    6. Напишите функциональный интерфейс для объединения двух списков в один
*/

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class AllTasksApp {
    public static <T> void main(String[] args) {

        // Task 1
        UnaryOperator<String> toUpperCase = str -> str.toUpperCase();
        System.out.println(toUpperCase.apply("Hello World!"));

        // Task 2
        BinaryOperator<Integer> sum = (x, y) -> x + y;
        System.out.println("Summa = " + sum.apply(7, 8));

        // Task 3
        Function<String, Boolean> isPalindrome = str -> {
            int length = str.length();
            String strToCheck = toUpperCase.apply(str);
            for (int i = 0; i < length / 2; i++) {
                if (strToCheck.charAt(i) != strToCheck.charAt(length - i - 1)) {
                    return false;
                }
            }
            return true;
        };
        System.out.println("Is palindrome = " + isPalindrome.apply("Level"));
        System.out.println("Is palindrome = " + isPalindrome.apply("system"));

        // Task 4
        Consumer<Integer> printFactorial = num -> {
            int result = 1;
            for (int i = 1; i <= num; i++) {
                result *= i;
            }
            System.out.println("Factorial of " + num + " = " + result);
        };
        printFactorial.accept(6);
        printFactorial.accept(0);

        // Task 5
        Predicate<Integer> isPrime = num -> {
            if (num < 2) {
                return false;
            }
            for (int i = 2; i <= num / 2; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        };
        System.out.println("Is number 123 prime = " + isPrime.test(123));
        System.out.println("Is number 67 prime = " + isPrime.test(67));

        // Task 6
        BiFunction<List<T>, List<T>, List<T>> concat = (list1, list2) -> {
            List<T> result = new ArrayList<>(list1);
            result.addAll(list2);
            return result;
        };
        List<Integer> listInt1 = new ArrayList<>(List.of(1, 2, 3));
        List<Integer> listInt2 = new ArrayList<>(List.of(4, 5, 6));
        System.out.println("Concatenated list = " + concat.apply((List<T>) listInt1, (List<T>) listInt2));
        List<String> listStr1 = new ArrayList<>(List.of("Hello", "World"));
        List<String> listStr2 = new ArrayList<>(List.of("Java", "Python"));
        System.out.println("Concatenated list = " + concat.apply((List<T>) listStr1, (List<T>) listStr2));
    }
}
