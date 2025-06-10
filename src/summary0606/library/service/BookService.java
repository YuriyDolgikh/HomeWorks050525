package summary0606.library.service;

import summary0606.library.entity.Book;
import summary0606.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book[] findAll() {
        return bookRepository.getAllBooks();
    }

    public Book findById(int id) {
        return bookRepository.getBookById(id);
    }

    public Book findByName(String name) {
        return bookRepository.getBookByName(name);
    }

    public Book[] findByAuthor(String author) {
        return bookRepository.getBooksByAuthor(author);
    }

    // Сохраняем книгу в массив.
    // Если имя книги уже присутствует - возвращаем 0
    // Если свободных мест нет - возвращаем -1
    // Если успешно - возвращаем номер следующей пустой ячейки (это уже > 0)
    public int addBookIntoLibrary(String name, String author) {
        if (!bookRepository.isBookNameUnique(name)) {
            return 0;
        }
        if (bookRepository.saveBook(new Book(name, author))) {
            return bookRepository.getLastBookNumber();
        } else {
            return -1;
        }
    }

    public boolean deleteBookFromLibrary(int id) {
        return bookRepository.deleteBookById(id);
    }

    public int getBookQuantity() {
        return findAll().length;
    }
}
