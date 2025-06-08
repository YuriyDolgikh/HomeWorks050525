package summary0606.library.userInterface;

import summary0606.library.service.BookService;
import utils.UserInputStatic;

public class UserMenu {
    BookService bookService;
    UserMenuService userMenuService;

    public UserMenu(BookService bookService) {
        this.bookService = bookService;
        this.userMenuService = new UserMenuService(bookService);
    }

    public void menu() {
        String menuItem = "";
        while (!menuItem.equals("0")) {
            userMenuService.showMainUserMenu();
            menuItem = UserInputStatic.inputText("Enter the command:");
            switch (menuItem) {
                case "1":
                    userMenuService.createBookByCustomer();
                    break;
                case "2":
                    int idForDelete = UserInputStatic.inputInt("Enter Book ID for delete:");
                    userMenuService.deleteBookByID(idForDelete);
                    break;
                case "3":
                    userMenuService.showBooksArray(bookService.findAll());
                    break;
                case "4":
                    int id = UserInputStatic.inputInt("Enter Book ID:");
                    userMenuService.showBook(bookService.findById(id));
                    break;
                case "5":
                    String name = UserInputStatic.inputText("Enter Book Name:");
                    userMenuService.showBook(bookService.findByName(name));
                    break;
                case "6":
                    String author = UserInputStatic.inputText("Enter Book Author:");
                    userMenuService.showBooksArray(bookService.findByAuthor(author));
                    break;
                case "7":
                    userMenuService.fillDataForTesting();
                    break;
                case "0":
                    System.out.println("Thank you for using this program.");
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }
}
