package backEndCourse.lesson01.abstraction.task1;

/*
    Создайте абстрактный класс InputDevice, который включает абстрактные методы
    connect и disconnect, а также может содержать поля или неабстрактные методы,
    общие для всех устройств ввода.
    От этого абстрактного класса наследуйте классы Keyboard и Mouse, реализуя абстрактные методы.
 */

abstract class InputDevice {

    protected String brand;
    protected String model;

    public InputDevice(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public void printInfo() {
        System.out.println("Class: " + this.getClass().getSimpleName());
        System.out.println("Brand: " + brand + "    Model: " + model);
    }

    public abstract void connect();
    public abstract void disconnect();
}
