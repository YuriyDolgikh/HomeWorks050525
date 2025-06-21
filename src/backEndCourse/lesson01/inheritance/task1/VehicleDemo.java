package backEndCourse.lesson01.inheritance.task1;

public class VehicleDemo {
    public static void main(String[] args) {
        Car car = new Car("BMW", "Blue", 4, 5, 4, 82);
        Bicycle bicycle = new Bicycle("Kawasaki", "Red", 2, 1, 150, "Mountain");
        car.printInfo();
        System.out.println();
        bicycle.printInfo();
    }
}
