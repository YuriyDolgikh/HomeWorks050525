package javaBasicCourse.lesson04.task04;

    /*
    1.  Создайте класс Manager.
        В этом классе создайте два поля: age и salary.
        Эти поля (переменные) должны быть типов, соответствующих смыслу данных, которые будут
        в них храниться. Например, age - возраст может иметь только целочисленные значения.

    2.  В методе main создайте экземпляр этого класса. Присвойте полям значения.
        Выведите на экран информацию о менеджере.
        Ваш менеджер отметил свой день рождения.
        Внесите необходимые изменения в данные и снова выведите информацию о менеджере на консоль.

    3.  Создайте второго менеджера и осуществите с ним такие же операции.
     */

public class MainApp {
    public static void main(String[] args) {
        Manager john = new Manager();
        john.age = 25;
        john.salary = 6000;
        System.out.println("John's age: " + john.age + " and salary: " + john.salary);
        System.out.println("John has birthday!");
        john.birthday();
        System.out.println("John's new age: " + john.age + " and salary: " + john.salary);

        System.out.println();

        Manager bill = new Manager();
        bill.age = 52;
        bill.salary = 8125;
        System.out.println("Bill's age: " + bill.age + " and salary: " + bill.salary);
        System.out.println("Bill has birthday!");
        bill.birthday();
        System.out.println("Bill's new age: " + bill.age + " and salary: " + bill.salary);
    }
}
