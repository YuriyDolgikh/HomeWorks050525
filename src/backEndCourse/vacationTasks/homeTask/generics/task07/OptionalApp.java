package backEndCourse.vacationTasks.homeTask.generics.task07;

/*
    7) Создайте класс Optional для представления значения, которое может
       отсутствовать. Реализуйте методы isPresent(), get() и orElse().
       Используйте Generics для возможности хранения в Optional объектов
       разных типов.
*/

public class OptionalApp {
    public static void main(String[] args) {
        Optional<String> optStringExist = new Optional<>("Real string");
        Optional<String> optStringNull = new Optional<>(null);

        if (optStringExist.isPresent()) {
            System.out.println(optStringExist.get());
        }

        System.out.println(optStringExist.orElse("String is not present (null)"));
        System.out.println(optStringNull.orElse("String is not present (null)"));
    }
}
