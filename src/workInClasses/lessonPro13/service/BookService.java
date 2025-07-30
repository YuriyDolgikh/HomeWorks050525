package workInClasses.lessonPro13.service;

import workInClasses.lessonPro13.entity.Author;
import workInClasses.lessonPro13.entity.Book;
import workInClasses.lessonPro13.repository.BookRepository;

import java.util.List;
import java.util.Optional;

public class BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public BookService(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    public boolean addBook(String isbn, String title, int authorId, String description) {
        Optional<Author> authorOptional = authorService.getAuthorById(authorId);
        if (!authorOptional.isPresent()) {
            return false;
        }
        Author author = authorOptional.get();

        for (Book book : bookRepository.getBooks()) {
            if (book.getIsbn().equals(isbn)) {
                return false;
            }
            if (book.getTitle().equalsIgnoreCase(title) || book.getAuthor().getId() == authorId) {
                return false;
            }
        }
            bookRepository.addBook(new Book(isbn, title, author, description));
            return true;
    }

    public Optional<Book> getBookByIsbn(String isbn){
        Book book = bookRepository.getBookByIsbn(isbn);
        if (book == null) {
            return Optional.empty();
        }
        return Optional.of(book);
    }

    public List<Book> getAllBooks(){
        return bookRepository.getBooks();
    }

    public List<Book> getBooksByTitle(String title){
        return bookRepository.getBooksByName(title);
    }

    public List<Book> getBooksByAuthor(String authorName){
        return bookRepository.getBooksByAuthorName(authorName);
    }

}
