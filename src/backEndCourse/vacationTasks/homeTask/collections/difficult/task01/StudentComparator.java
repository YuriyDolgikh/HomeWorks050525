package backEndCourse.vacationTasks.homeTask.collections.difficult.task01;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        int result = o2.getGrade() - o1.getGrade();
        if (result == 0){
            result = o1.getName().compareTo(o2.getName());
        }
        return result;
    }
}
