package workInClasses.lessonPro07.task1;

import java.util.*;

public class BooksApp {
    public static void main(String[] args) {
        Book book1 = new Book("Java", "Herbert Schildt", 2000);
        Book book2 = new Book("Core Java", "Gary Cornell", 2001);
        Book book3 = new Book("C#", "Jeffrey Richter", 2005);
        Book book4 = new Book("Python", "Allen Downey", 2010);

        BookComparatorByTitle comparatorByTitle = new BookComparatorByTitle();
        BookComparatorByAuthor comparatorByAuthor = new BookComparatorByAuthor();
        BookComparatorByYear comparatorByYear = new BookComparatorByYear();

        Set<Book> bookByTitle = new TreeSet<>(comparatorByTitle);
        bookByTitle.add(book1);
        bookByTitle.add(book2);
        bookByTitle.add(book3);
        bookByTitle.add(book4);

        Set<Book> bookByAuthor = new TreeSet<>(comparatorByAuthor);
        bookByAuthor.addAll(bookByTitle);

        Set<Book> bookByYear = new TreeSet<>(comparatorByYear);
        bookByYear.addAll(bookByTitle);

        System.out.println("Books by title:");
        for (Book book : bookByTitle) {
            System.out.println(book);
        }
        System.out.println();
        System.out.println("Books by author:");
        for (Book book : bookByAuthor) {
            System.out.println(book);
        }
        System.out.println();
        System.out.println("Books by year:");
        for (Book book : bookByYear) {
            System.out.println(book);
        }
    }
}
