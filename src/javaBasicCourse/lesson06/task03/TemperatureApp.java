package javaBasicCourse.lesson06.task03;

/*
    Задача 3.
    Класс для управления температурой

    Создайте класс Temperature, который будет представлять температуру в градусах Цельсия и
    предоставлять методы для преобразования температуры в другие единицы.

    Методы:

    Double toFahrenheit(double celsius) — возвращает температуру в градусах Фаренгейта.

    В методе main() задайте значение температуры в градусах Цельсия,
    вызовите метод toFahrenheit(double celsius),
    сохраните полученный результат и распечатайте его
 */

public class TemperatureApp {
    public static void main(String[] args) {
        Temperature temperature = new Temperature();
        double fahrenheit = temperature.toFahrenheit(0);
        System.out.println("Fahrenheit: " + fahrenheit);
    }
}
