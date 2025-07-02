package javaBasicCourse.lesson07.task01;

/*
    Задача 1: Класс "Работник" (Employee)

    Условие: Создайте класс Employee, который описывает работника с полями:
        name (имя, строка)
        hoursWorked (количество отработанных часов за месяц, целое число)
        hourlyRate (почасовая ставка, число с плавающей точкой)
        monthlySalary (месячная зарплата, число с плавающей точкой)

    Требования:
        Создайте конструктор, который принимает имя, часы работы и почасовую ставку.
        При создании объекта, в конструкторе рассчитывайте месячную зарплату как произведение часов на ставку и сохраняйте в поле monthlySalary.
        Реализуйте геттеры и сеттеры для всех полей.
        Переопределите метод toString(), чтобы он возвращал строку с описанием работника в формате:

            Работник [name]: отработано [hoursWorked] часов, ставка [hourlyRate], месячная зарплата: [monthlySalary].

    В основной программе:
        Создайте объект класса Employee.
        Выведите данные с использованием метода toString().
        Измените количество отработанных часов с помощью сеттера, пересчитайте зарплату и снова выведите данные.
 */

public class EmployeeApp {
    public static void main(String[] args) {
        Employee employee = new Employee("John", 155, 18);
        System.out.println(employee);
        System.out.println();
        employee.setHoursWorked(160);
        employee.calcSalary();
        System.out.println(employee);
    }
}
