package lesson14.task02greeter;

public class Greeter {
    public void greet(String name, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println("Hello, " + name + "!");
        }
    }
}
