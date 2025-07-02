package javaBasicCourse.lesson05.task03;

/*
    Задача 3: Класс для управления температурой

    Создайте класс Temperature, который будет хранить данные о температуре в градусах Цельсия и
    градусах Фаренгейта и предоставлять метод для преобразования температуры из Цельсия в Фаренгейт.

    Методы:

    public void toFahrenheit() — переводит температуру в градусы Фаренгейта.

    В методе main() создайте экземпляр класса и задайте значение температуры в градусах Цельсия,
    вызовите метод toFahrenheit() и распечатайте полученный результат о температуре в Фаренгейт
 */

public class TemperatureApp {
    public static void main(String[] args) {
        Temperature temperature = new Temperature(22);
        temperature.toFahrenheit();
        temperature.printTemperatureInFahrenheit();
    }
}
