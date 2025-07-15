package backEndCourse.vacationTasks.homeTask.collections.difficult.task05;

/*
    5 Создать класс Book со свойствами title, author и year (год издания), затем создать список LinkedList, заполнить
      его несколькими объектами Book и удалить из списка все книги, которые были изданы до 2000 года.
 */

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BooksApp {
    public static void main(String[] args) {
        List<Book> books = new LinkedList<>();
        books.add(new Book("Insomnia", "Stephen King", 1992));
        books.add(new Book("Angels & Demons", "Dan Brown", 2000));
        books.add(new Book("The Bourne Identity", "Robert Ludlum", 1981));
        books.add(new Book("The Da Vinci Code", "Dan Brown", 2004));
        books.add(new Book("The Girl with the Dragon Tattoo", "Stieg Larsson", 2008));
        printBooks(books);

        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getYear() < 2000) {
                iterator.remove();
            }
        }
        System.out.println("Books after removing:");
        printBooks(books);
    }

    public static void printBooks(List<Book> books) {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
