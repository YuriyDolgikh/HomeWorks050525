package backEndCourse.lesson01.inheritance.task1;

/*
    Создайте базовый класс Vehicle с общими свойствами и методами для транспортных средств.
    Затем создайте производные классы Car и Bicycle, расширяющие класс Vehicle,
    добавляя специфические свойства и методы (например, количество дверей для автомобиля).
 */

public class Vehicle {
    private String brand;
    private String color;
    private int numberOfWheels;
    private int numberOfSeats;

    public Vehicle(String brand, String color, int numberOfWheels, int numberOfSeats) {
        this.brand = brand;
        this.color = color;
        this.numberOfWheels = numberOfWheels;
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public String getColor() {
        return color;
    }

    public String getBrand() {
        return brand;
    }
}
