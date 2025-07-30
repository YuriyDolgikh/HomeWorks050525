package workInClasses.lessonPro13.repository;


import workInClasses.lessonPro13.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    List<Book> books = new ArrayList<>();

    public void addBook(Book book){
        books.add(book);
    }

    public List<Book> getBooks(){
        return books;
    }

    public Book getBookByIsbn(String isbn){
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public List<Book> getBooksByName(String name){
        List<Book> booksByName = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().contains(name)) {
                booksByName.add(book);
            }
        }
        return booksByName;
    }

    public List<Book> getBooksByAuthorName(String authorName){
        List<Book> booksByAuthorName = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().getAuthorName().contains(authorName)) {
                booksByAuthorName.add(book);
            }
        }
        return booksByAuthorName;
    }

}
