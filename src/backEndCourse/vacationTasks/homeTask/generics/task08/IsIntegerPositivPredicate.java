package backEndCourse.vacationTasks.homeTask.generics.task08;

import java.util.function.Predicate;

public class IsIntegerPositivPredicate implements Predicate<Integer> {
    @Override
    public boolean test(Integer number) {
        return number > 0;
    }
}
