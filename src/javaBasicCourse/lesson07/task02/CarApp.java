package javaBasicCourse.lesson07.task02;

/*
    Задача 2: Класс "Автомобиль" (Car)

    Условие:
    Создайте класс Car, который описывает автомобиль с полями:
        Brand (марка автомобиля, строка)
        Model (модель автомобиля, строка)
        fuelConsumption (расход топлива на 100 км, число с плавающей точкой)
        fuelTankCapacity (объем топливного бака, число с плавающей точкой)
        maxDistance (максимальная дистанция на полном баке, число с плавающей точкой)

    Требования:
    Создайте конструктор, который принимает марку, модель, расход топлива и объем бака.
    При создании объекта рассчитывайте максимальную дистанцию на полном баке как:
        maxDistance = fuelTankCapacity * 100 / fuelConsumption
            и сохраняйте значение в поле maxDistance.
    Реализуйте геттеры и сеттеры для всех полей.
    Переопределите метод toString(), чтобы он возвращал строку с описанием автомобиля в формате:
        Автомобиль [brand] [model]: расход топлива [fuelConsumption] л/100 км, объем бака [fuelTankCapacity] л, максимальная дистанция [maxDistance] км.

    В основной программе:
    Создайте объект класса Car.
    Выведите данные с использованием метода toString().
    Измените расход топлива с помощью сеттера, пересчитайте максимальную дистанцию и снова выведите данные.
 */

public class CarApp {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Corolla", 7.5, 45);
        System.out.println(car);
        System.out.println();
        car.setFuelConsumption(8);
        car.calcMaxDistance();
        System.out.println(car);
    }
}
