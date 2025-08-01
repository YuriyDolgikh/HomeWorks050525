package backEndCourse.lesson14.task09;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class OrdersApp {
    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1, "02-01-2025", 1000, true));
        orders.add(new Order(2, "13-01-2025", 1300, false));
        orders.add(new Order(3, "26-01-2025", 1200, true));
        orders.add(new Order(4, "16-02-2025", 1200, false));
        orders.add(new Order(5, "22-02-2025", 1200, true));
        orders.add(new Order(6, "28-02-2025", 1200, false));
        orders.add(new Order(7, "05-03-2025", 1200, true));
        orders.add(new Order(8, "07-03-2025", 1200, false));
        orders.add(new Order(9, "20-04-2025", 1200, true));
        orders.add(new Order(10, "24-04-2025", 1200, false));
        orders.add(new Order(11, "05-05-2025", 1200, true));
        orders.add(new Order(12, "07-05-2025", 1200, false));
        orders.add(new Order(13, "18-05-2025", 1200, true));
        orders.add(new Order(14, "10-06-2025", 1200, false));
        orders.add(new Order(15, "12-06-2025", 1200, false));
        orders.add(new Order(16, "15-06-2025", 1200, false));
        orders.add(new Order(17, "03-07-2025", 1200, false));
        orders.add(new Order(18, "14-07-2025", 1200, false));
        orders.add(new Order(19, "26-07-2025", 1200, false));

        Map<String, Double> monthlyOrders = orders.stream().
                collect(groupingBy(
                        order -> order.getDate().substring(3, 5),
                        Collectors.summingDouble(Order::getSumma)
                ));

        monthlyOrders.forEach((key, value) -> System.out.println("Month: " + key + " => Total sum: " + value));
    }
}
