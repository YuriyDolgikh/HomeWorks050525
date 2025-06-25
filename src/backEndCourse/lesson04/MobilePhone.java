package backEndCourse.lesson04;

import java.util.Objects;

public class MobilePhone {
    private String brand;
    private String model;

    public MobilePhone(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MobilePhone that)) return false;
        return Objects.equals(brand, that.brand) && Objects.equals(model, that.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model);
    }

    @Override
    public String toString() {
        return String.format("Brand: '%s', Model: '%s'", brand, model);
    }
}
