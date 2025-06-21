package backEndCourse.lesson01.inheritance.task1;

public class Car extends Vehicle{

    int numberOfDoors;
    int tankVolume;

    public Car(String brand, String color, int numberOfWheels, int numberOfSeats, int numberOfDoors, int tankVolume) {
        super(brand, color, numberOfWheels, numberOfSeats);
        this.numberOfDoors = numberOfDoors;
        this.tankVolume = tankVolume;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public int getTankVolume() {
        return tankVolume;
    }

    public void printInfo() {
        System.out.println("Brand: " + super.getBrand() +
                            "\nColor: " + super.getColor() +
                            "\nNumber of wheels: " + super.getNumberOfWheels() +
                            "\nNumber of seats: " + super.getNumberOfSeats() +
                            "\nNumber of doors: " + numberOfDoors +
                            "\nTank volume: " + tankVolume + "L");
    }
}
