package lesson20.taskVar4;

public class BookDemo {
    public static void main(String[] args) {
        BookRepository bookRepository = new BookRepository(UserInterface.getLibraryDimension());
        BookService bookService = new BookService(bookRepository);
        UserInterface userInterface = new UserInterface(bookService);
        userInterface.menu();
    }
}
