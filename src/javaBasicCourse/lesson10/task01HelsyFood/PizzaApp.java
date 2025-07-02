package javaBasicCourse.lesson10.task01HelsyFood;

public class PizzaApp {
    public static void main(String[] args) {
        Pizza pizzaOne = new Pizza(24,40);
        Pizza pizzaTwo = new Pizza(28,40);
        System.out.println("Difference of calories: " + PizzaService.getDifferenceOfCalories(pizzaOne, pizzaTwo));
    }
}
