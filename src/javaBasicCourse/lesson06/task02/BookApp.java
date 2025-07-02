package javaBasicCourse.lesson06.task02;

/*
Задача 2.
    Создайте класс Book, в котором будут поля: название, автор и находится ли книга в библиотеке или выдана читателю.
    Напишите метод, который осуществляет "выдачу" книги и "возврат" ее от читателя
 */

public class BookApp {
    public static void main(String[] args) {
        Book book = new Book("Some book", "Some author", true);
        book.printInfo();
        book.setIsIssued(false);
        book.printInfo();
        book.setIsIssued(true);
        book.printInfo();
    }
}
