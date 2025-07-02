package javaBasicCourse.lesson05.task01;

/*
    Задача 1: Класс для описания книги

    Создайте класс Book, который будет использоваться для хранения информации о книгах в библиотеке.
    Класс должен иметь следующие поля и методы:

    Поля:
        title (название книги, тип String)
        author (автор книги, тип String)
        year (год издания, тип int)
        isIssued (флаг, выдана книга или нет, тип boolean)

    Создайте два экземпляра класса, заполните поля данными и распечатайте их
 */

public class BookApp {
    public static void main(String[] args) {
        Book book1 = new Book("Thinking in Java 4th Edition", "Bruce Eckel", 2006, false);
        Book book2 = new Book("Clean Code", "Robert C. Martin", 2009, true);
        book1.printBookInfo();
        System.out.println("----------------------------------------");
        book2.printBookInfo();
    }
}
