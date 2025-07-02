package javaBasicCourse.lesson04.task01;

    /*
    Пусть цена товара A обычно составляет 1000, и товара B составляет 500.
    Если клиент покупает товары вместе, то на них действует скидка 100 на всю покупку.
    Выведите на экран переменную, которая соответствует стоимости суммы A+B со скидкой.
    Отдельно выведите на экран сумму скидки от этой покупки.
     */

public class Prices {
    public static void main(String[] args) {
        int productPriceA = 1000;
        int productPriceB = 500;
        int discount = 100;

        int sumPriceWidthDiscount = productPriceA + productPriceB - discount;
        System.out.println("Summary price with discount: " + sumPriceWidthDiscount);
        System.out.println("Discount: " + discount);
    }
}
