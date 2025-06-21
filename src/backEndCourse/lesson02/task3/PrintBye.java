package backEndCourse.lesson02.task3;

public class PrintBye implements Command{
    @Override
    public void execute() {
        System.out.println("Bye!");
    }
}
