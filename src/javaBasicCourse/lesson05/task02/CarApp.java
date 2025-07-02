package javaBasicCourse.lesson05.task02;

/*
    Задача 2: Класс для описания автомобиля

    Создайте класс Car, который описывает автомобиль.
    Класс должен иметь следующие поля и методы:

    Поля:
        brand (марка автомобиля, тип String)
        model (модель автомобиля, тип String)
        year (год выпуска, тип int)
        mileage (пробег, тип int)

    Создайте два экземпляра класса, заполните поля данными и распечатайте их
 */

public class CarApp {
    public static void main(String[] args) {
        Car car1 = new Car("BMW", "X5", 2019, 100000);
        Car car2 = new Car("Toyota", "Corolla", 2018, 150000);
        car1.printCarInfo();
        System.out.println("----------------------------------------");
        car2.printCarInfo();
    }
}
