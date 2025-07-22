package backEndCourse.vacationTasks.homeTask.optional.task10;

import java.util.function.Predicate;

public class StringPredicate implements Predicate <String> {
    @Override
    public boolean test(String string) {
        return string.toLowerCase().contains("s");
    }
}
