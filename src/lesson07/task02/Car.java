package lesson07.task02;

public class Car {
    private String brand;
    private String model;
    private double fuelConsumption;
    private double fuelTankCapacity;
    private double maxDistance;

    public Car(String brand, String model, double fuelConsumption, double fuelTankCapacity) {
        this.brand = brand;
        this.model = model;
        this.fuelConsumption = fuelConsumption;
        this.fuelTankCapacity = fuelTankCapacity;
        this.maxDistance = fuelTankCapacity * 100 / fuelConsumption;
    }

    public void calcMaxDistance() {
        maxDistance = fuelTankCapacity * 100 / fuelConsumption;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuelTankCapacity() {
        return fuelTankCapacity;
    }

    public void setFuelTankCapacity(double fuelTankCapacity) {
        this.fuelTankCapacity = fuelTankCapacity;
    }

    public double getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(double maxDistance) {
        this.maxDistance = maxDistance;
    }

    @Override
    public String toString() {
        return "Car " + brand + " " + model + ": fuel consumption " + fuelConsumption +
                " l/100 km, tank capacity " + fuelTankCapacity + " l, max distance " + maxDistance + " km.";
    }
}
