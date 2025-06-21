package backEndCourse.lesson01.inheritance.task1;

public class Bicycle extends Vehicle{

    int maxWeight;
    String type;

    public Bicycle(String brand, String color, int numberOfWheels, int numberOfSeats, int maxWeight, String type) {
        super(brand, color, numberOfWheels, numberOfSeats);
        this.maxWeight = maxWeight;
        this.type = type;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public String getType() {
        return type;
    }

    public void printInfo() {
        System.out.println("Brand: " + super.getBrand() +
                            "\nColor: " + super.getColor() +
                            "\nNumber of wheels: " + super.getNumberOfWheels() +
                            "\nNumber of seats: " + super.getNumberOfSeats() +
                            "\nMax weight: " + maxWeight +
                            "\nType: " + type);
    }
}
