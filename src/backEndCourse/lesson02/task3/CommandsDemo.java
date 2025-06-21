package backEndCourse.lesson02.task3;

public class CommandsDemo {
    public static void main(String[] args) {
        Command[] commands = {new PrintHello(), new PrintDate(), new PrintBye()};
        runAll(commands);
    }

    private static void runAll(Command[] commands){
        for (Command command : commands) {
            command.execute();
        }
    }
}
