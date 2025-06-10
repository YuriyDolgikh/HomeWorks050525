package summary0606.library.repository;

import summary0606.library.config.LibraryConfig;
import summary0606.library.entity.Book;

public class BookRepository {
    private final Book[] books;
    private int lastBookNumber; // индекс последней ячейки в массиве, занятый книгой

    public BookRepository() {
        this.books = new Book[LibraryConfig.MAX_BOOKS];
        this.lastBookNumber = 0;
    }

    public boolean isBookNameUnique(String name) {
        for (Book book : books) {
            if (book == null) {
                return true;
            }
            if (book.getName().equalsIgnoreCase(name)) {
                return false;
            }
        }
        return true;
    }

    public int getLastBookNumber() {
        return lastBookNumber;
    }

    public boolean saveBook(Book book) {
        if (lastBookNumber < books.length) {
            books[lastBookNumber++] = book;
            return true;
        }
        return false;
    }

    public Book getBookById(int id) {
        for (Book book : books) {
            if (book == null) {
                return null;
            }
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    // По условию задачи - имя книги уникальное. Берем первую в списке
    public Book getBookByName(String name) {
        for (Book book : books) {
            if (book == null) {
                return null;
            }
            if (book.getName().toLowerCase().contains(name.toLowerCase())) {
                return book;
            }
        }
        return null;
    }

    public Book[] getBooksByAuthor(String author) {
        int booksCounterByAuthor = 0;
        if (lastBookNumber == 0) {
            return null;
        }
        for (Book book : getAllBooks()) {
            if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                booksCounterByAuthor++;
            }
        }
        Book[] booksByAuthor = new Book[booksCounterByAuthor];
        int bookIndex = 0;
        for (int i = 0; i < getAllBooks().length; i++) {
            if (books[i].getAuthor().toLowerCase().contains(author.toLowerCase())) {
                booksByAuthor[bookIndex++] = books[i];
            }
        }
        return booksByAuthor;
    }

    public Book[] getAllBooks() {
        Book[] result = new Book[lastBookNumber];
        System.arraycopy(books, 0, result, 0, lastBookNumber);
        return result;
    }

    private int getIndexById(int id) {
        for (int i = 0; i < lastBookNumber; i++) {
            if (books[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public boolean deleteBookById(int id) {
        int numberBookForDelete = getIndexById(id);   // numberBookForDelete - индекс книги в массиве для удаления
        if (numberBookForDelete == -1) {
            return false;
        }
        if (numberBookForDelete == lastBookNumber - 1) {
            books[numberBookForDelete] = null;
        } else {
            for (int i = numberBookForDelete; i < lastBookNumber - 1; i++) {
                books[i] = books[i + 1];
            }
            books[lastBookNumber - 1] = null;
        }
        lastBookNumber--;
        return true;
    }
}
