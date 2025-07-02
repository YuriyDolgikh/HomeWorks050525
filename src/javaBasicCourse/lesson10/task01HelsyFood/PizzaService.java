package javaBasicCourse.lesson10.task01HelsyFood;

public class PizzaService {
    public static double getDifferenceOfCalories(Pizza pizzaOne, Pizza pizzaTwo) {
        return Math.abs(pizzaOne.getCaloriesTotal() - pizzaTwo.getCaloriesTotal());
    }
}
