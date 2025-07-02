package workInClasses.lessonPro07.task2;

import java.util.Comparator;

public class EmployeeComparatorById implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getEmployeeId() - o2.getEmployeeId();
    }
}
