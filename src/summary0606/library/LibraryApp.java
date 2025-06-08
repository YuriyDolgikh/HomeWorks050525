package summary0606.library;

import summary0606.library.repository.BookRepository;
import summary0606.library.service.BookService;
import summary0606.library.userInterface.UserMenu;

public class LibraryApp {
    public static void main(String[] args) {

        BookRepository bookRepository = new BookRepository();
        BookService bookService = new BookService(bookRepository);
        UserMenu userMenu = new UserMenu(bookService);

        userMenu.menu();
    }
}
