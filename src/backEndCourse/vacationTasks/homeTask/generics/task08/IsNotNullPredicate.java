package backEndCourse.vacationTasks.homeTask.generics.task08;

import java.util.function.Predicate;

public class IsNotNullPredicate implements Predicate<String> {
    @Override
    public boolean test(String o) {
        return o != null;
    }
}
