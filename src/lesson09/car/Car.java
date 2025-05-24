package lesson09.car;

public class Car {
    private String model;
    private Producer producer;
    private String color;

    public Car(String model, Producer producer, String color) {
        this.model = model;
        this.producer = producer;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", producer=" + producer +
                ", color='" + color + '\'' +
                '}';
    }
}
