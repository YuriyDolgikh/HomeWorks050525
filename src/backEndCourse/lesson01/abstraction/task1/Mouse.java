package backEndCourse.lesson01.abstraction.task1;

public class Mouse extends InputDevice{

    public Mouse(String brand, String model) {
        super(brand, model);
    }

    @Override
    public void connect() {
        System.out.println("Mouse connected");
    }

    @Override
    public void disconnect() {
        System.out.println("Mouse disconnected");
    }
}
