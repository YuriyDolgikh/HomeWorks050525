package workInClasses.lessonPro13.userInterface;

import utils.UserInputStatic;
import workInClasses.lessonPro13.service.AuthorService;
import workInClasses.lessonPro13.service.BookService;

public class BookManager {

    private final AuthorService authorService;
    private final BookService bookService;

    public BookManager(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    public void showMenu() {
        System.out.println("1. Add Author");
        System.out.println("2. Add Book");
        System.out.println("3. Find Author by ID");
        System.out.println("4. Find Book by ID");
        System.out.println("5. Find Author by Name");
        System.out.println("6. Find Book by ISBN");
        System.out.println("7. Find Books by Author");
        System.out.println("8. Find Books by Title");
        System.out.println("9. Exit");
    }

    public void run() {
        boolean isRunning = true;
        while (isRunning){
            showMenu();
            int choice = UserInputStatic.inputInt("Enter your choice: ");
            switch (choice){
                case 1:
                    int id = UserInputStatic.inputInt("Enter ID for author:");
                    String name = UserInputStatic.inputText("Enter name for author:");
                    String info = UserInputStatic.inputText("Enter info for author:");
                    boolean result = authorService.addAuthor(id, name, info);
                    if (result){
                        System.out.println("Author added successfully");
                    }else{
                        System.out.println("Something went wrong");
                    }
                    break;
                case 2:
                    String isbn = UserInputStatic.inputText("Enter ISBN for book:");
                    String title = UserInputStatic.inputText("Enter title for book:");
                    int authorId = UserInputStatic.inputInt("Enter ID for author:");
                    String description = UserInputStatic.inputText("Enter description for Book");
                    boolean result2 = bookService.addBook(isbn, title, authorId, description);
                    if (result2){
                        System.out.println("Book added successfully");
                    }else{
                        System.out.println("Something went wrong");
                    }
                    break;
                case 3:
//                    authorService.findAuthorById();
            }
        }

    }
}
