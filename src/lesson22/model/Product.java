package lesson22.model;

import java.util.Objects;

public class Product {

    private String catalogNumber;
    private String brand;
    private String category;
    private String name;
    private double price;

    public Product(String catalogNumber, String brand, String category, String name, double price) {
        this.catalogNumber = catalogNumber;
        this.brand = brand;
        this.category = category;
        this.name = name;
        this.price = price;
    }

    public String getCatalogNumber() {
        return catalogNumber;
    }

    public String getBrand() {
        return brand;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Catalog number: '%s', Brand: '%s', Category: '%s', Name: '%s', Price: %.2f",
                catalogNumber, brand, category, name, price);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Product product)) return false;
        return Double.compare(price, product.price) == 0 && Objects.equals(catalogNumber, product.catalogNumber) && Objects.equals(brand, product.brand) && Objects.equals(category, product.category) && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(catalogNumber, brand, category, name, price);
    }
}
