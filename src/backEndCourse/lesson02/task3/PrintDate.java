package backEndCourse.lesson02.task3;

import java.util.Date;

public class PrintDate implements Command{
    @Override
    public void execute() {
        System.out.println("Today is " + new Date().toString().substring(4, 10));
    }
}
