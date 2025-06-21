package backEndCourse.lesson01.abstraction.task1;

public class Keyboard extends InputDevice{

    public Keyboard(String brand, String model) {
        super(brand, model);
    }

    @Override
    public void connect() {
        System.out.println("Keyboard connected");
    }

    @Override
    public void disconnect() {
        System.out.println("Keyboard disconnected");
    }
}
