package javaBasicCourse.lesson05.task02;

public class Car {

    String brand;
    String model;
    int year;
    int mileage;

    public Car(String brand, String model, int year, int mileage) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
    }

    public void printCarInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Mileage: " + mileage);
    }
}
