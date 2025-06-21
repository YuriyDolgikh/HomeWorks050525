package backEndCourse.lesson01.abstraction.task1;

public class InputDeviceDemo {
    public static void main(String[] args) {
        InputDevice keyboard = new Keyboard("Cherry", "Stream S-65");
        keyboard.printInfo();
        keyboard.connect();
        keyboard.disconnect();
        InputDevice mouse = new Mouse("Logitech", "M112");
        mouse.printInfo();
        mouse.connect();
        mouse.disconnect();
    }
}
