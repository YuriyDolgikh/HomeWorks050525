package javaBasicCourse.lesson06.task01;

/*
    Задача 1.
    Пусть цена товара A обычно составляет 1000 euro, и товара B составляет 500 euro.
    Клиент покупает товары вместе, на них действует скидка 100 euro на всю покупку.
    Выведите на экран переменную, которая соответствует стоимости суммы A+B со скидкой.
    Отдельно выведите на экран сумму скидки от этой покупки.

    Создайте отдельный метод для расчета итоговой суммы покупки getTotalPrice(double priceA, double priceB, double discount)
 */

public class Shop {
    public static void main(String[] args) {

        double priceA = 1000;
        double priceB = 500;
        double discount = 100;

        System.out.println("Total price: " + getTotalPrice(priceA, priceB, discount));
        System.out.println("Discount: " + discount);
    }

    static double getTotalPrice(double prA, double prB, double dsc) {
        return prA + prB - dsc;
    }
}
