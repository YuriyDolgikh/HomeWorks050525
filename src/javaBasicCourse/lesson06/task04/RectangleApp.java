package javaBasicCourse.lesson06.task04;

/*
    Задача 4.
    Класс для подсчета площади прямоугольника

    Создайте класс Rectangle, который будет представлять прямоугольник и предоставлять методы
    для вычисления его площади и периметра.

    Методы:

    double calculateArea(double length, double width) — возвращает площадь прямоугольника.
    double calculatePerimeter(double length, double width) — возвращает периметр прямоугольника.
 */

public class RectangleApp {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        double area = rectangle.calculateArea(15, 5.3);
        double perimeter = rectangle.calculatePerimeter(15, 5.3);
        System.out.println("Area: " + area);
        System.out.println("Perimeter: " + perimeter);
    }
}
