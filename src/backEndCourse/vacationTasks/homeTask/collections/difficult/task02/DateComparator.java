package backEndCourse.vacationTasks.homeTask.collections.difficult.task02;

import java.util.Comparator;

public class DateComparator implements Comparator<Date> {
    @Override
    public int compare(Date o1, Date o2) {
        int result = o1.getYear() - o2.getYear();
        if (result == 0){
            result = o1.getMonth() - o2.getMonth();
        }
        if (result == 0){
            result = o1.getDay() - o2.getDay();
        }
        return result;
    }
}
