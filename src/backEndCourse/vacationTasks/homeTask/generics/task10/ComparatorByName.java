package backEndCourse.vacationTasks.homeTask.generics.task10;

import java.util.Comparator;

public class ComparatorByName implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        int result = o1.getName().compareTo(o2.getName());
        if (result == 0) {
            result = o1.getId() - o2.getId();
        }
        if (result == 0) {
            result = o1.getGroup().compareTo(o2.getGroup());
        }
        return result;
    }
}
