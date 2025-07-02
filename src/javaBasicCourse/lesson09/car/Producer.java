package javaBasicCourse.lesson09.car;

public class Producer {
    private String brand;
    private String country;

    public Producer(String brand, String country) {
        this.brand = brand;
        this.country = country;
    }

    public String getBrand() {
        return brand;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Producer{" +
                "brand='" + brand + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
