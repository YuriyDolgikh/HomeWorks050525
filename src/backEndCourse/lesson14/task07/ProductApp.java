package backEndCourse.lesson14.task07;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductApp {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        products.add(new Product("Apple", "Fruit", 2.5, 10));
        products.add(new Product("Banana", "Fruit", 1.2, 25));
        products.add(new Product("Orange", "Fruit", 3.3, 17));
        products.add(new Product("Potato", "Vegetable", 1.5, 11));
        products.add(new Product("Carrot", "Vegetable", 1.1, 35));
        products.add(new Product("Tomato", "Vegetable", 2.3, 12));
        products.add(new Product("Onion", "Vegetable", 1.5, 7));
        products.add(new Product("Strawberry", "Berry", 8.2, 21));
        products.add(new Product("Grape", "Berry", 4.3, 14));
        products.add(new Product("Peach", "Berry", 5.3, 20));

        int quantityCriteria = 15;

        Map<String, Double> avgPrices = products.stream()
                .filter(p -> p.getQuantity() > quantityCriteria)
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.averagingDouble(Product::getPrice)
                ));

        avgPrices.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEach(entry -> System.out.println(
                        "Category: " + entry.getKey() + ", Avg Price: " + entry.getValue()));

    }
}
