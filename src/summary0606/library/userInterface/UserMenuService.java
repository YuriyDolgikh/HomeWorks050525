package summary0606.library.userInterface;

import summary0606.library.entity.Book;
import summary0606.library.service.BookService;
import utils.UserInputStatic;

public class UserMenuService {

    private BookService bookService;

    public UserMenuService(BookService bookService) {
        this.bookService = bookService;
    }

    public void showMainUserMenu() {
        System.out.println("Library. There are " + bookService.getBookQuantity() + " books available.");
        System.out.println("-------------------------------------");
        System.out.println("1. Add book");
        System.out.println("2. Delete book by ID");
        System.out.println("3. Show all books");
        System.out.println("4. Show book by id");
        System.out.println("5. Show book by name");
        System.out.println("6. Show books by author");
        System.out.println("7. Fill data for testing");
        System.out.println("0. Exit");
    }

    public void showBooksArray(Book[] books) {
        if (books != null && books.length > 0) {
            for (Book book : books) {
                System.out.println("Book ID: " + book.getId() +
                        "\tTitle: " + book.getName() +
                        " - Author: " + book.getAuthor());
            }
            System.out.println("-------------------------------------");
        } else {
            System.out.println("There are no books.");
            System.out.println("-------------------------------------");
        }
    }

    public void showBook(Book book) {
        if (book != null) {
            System.out.println("Book ID: " + book.getId());
            System.out.println("Title:   " + book.getName());
            System.out.println("Author:  " + book.getAuthor());
        } else {
            System.out.println("There is no book.");
        }
        System.out.println("-------------------------------------");
    }

    public void createBookByCustomer() {
        String bookName = UserInputStatic.inputText("Input the name of the book");
        String bookAuthor = UserInputStatic.inputText("Input the author of the book");
        int result = bookService.addBookIntoLibrary(bookName, bookAuthor);
        if (result == 0) {
            System.out.println("Book name is already exist in the library");
        } else if (result == -1) {
            System.out.println("There is no free space for books in the library");
        } else {
            System.out.println("New book added into the library with number: " + result);
        }
        System.out.println("-------------------------------------");
    }

    public void deleteBookByID(int id) {
        if (bookService.deleteBookFromLibrary(id)) {
            System.out.println("Book with ID: " + id + " deleted from the library");
        } else {
            System.out.println("Book with ID: " + id + " does not exist in the library");
        }
        System.out.println("-------------------------------------");
    }

    public void fillDataForTesting() {
        int startQuantity = bookService.getBookQuantity();
        bookService.addBookIntoLibrary("Alice's Adventures in Wonderland", "Lewis Carroll");
        bookService.addBookIntoLibrary("Treasure Island", "Robert Louis Stevenson");
        bookService.addBookIntoLibrary("The lost World", "Conan Doyle");
        bookService.addBookIntoLibrary("Short Stories", "Conan Doyle");
        int endQuantity = bookService.getBookQuantity();
        System.out.println(endQuantity - startQuantity + " books added to the library");
        System.out.println("-------------------------------------");
    }
}
