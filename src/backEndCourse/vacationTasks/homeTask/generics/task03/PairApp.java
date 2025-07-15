package backEndCourse.vacationTasks.homeTask.generics.task03;

/*
    3) Создайте класс Pair с двумя полями - first и second, и реализуйте
       методы getFirst() и getSecond() для доступа к этим полям.
       Используйте Generics для возможности хранения в Pair объектов
       разных типов.
*/

import java.util.Date;

public class PairApp {
    public static void main(String[] args) {
        Pair<String, Integer> pairStrInt = new Pair<>("John", 25);
        Pair<Boolean, Throwable> pairBoolThrow = new Pair<>(true, new Throwable());
        Pair<Date, Exception> pairDateEx = new Pair<>(new Date(), new NullPointerException());

        printPair(pairStrInt);
        printPair(pairBoolThrow);
        printPair(pairDateEx);
    }

    public static void printPair(Pair<?, ?> pair) {
        System.out.println("First: " + pair.getFirst() + ", Second: " + pair.getSecond());
    }
}
