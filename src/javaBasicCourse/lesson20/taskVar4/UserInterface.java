package javaBasicCourse.lesson20.taskVar4;

import utils.UserInputStatic;

public class UserInterface {

    private BookService bookService;

    public UserInterface(BookService bookService) {
        this.bookService = bookService;
    }

    // написать метод (методы) для:
    // - реализации меню
    // - ввода данных от пользователя для создания новой книги
    // - поиска по трем разным критериям
    // - вывода результатов работы этих методов для пользователя

    public static int getLibraryDimension() {
        return UserInputStatic.inputInt("Введите количество ячеек для книг в библиотеке:");
    }

    public void menu() {

        boolean whileNotExit = true;

        while (whileNotExit) {

            System.out.println("-------------------------");
            System.out.println("Виды операций:");
            System.out.println("1. Создать новую книгу");
            System.out.println("2. Вывод информации о всех книгах");
            System.out.println("3. Поиск книги на номеру каталога");
            System.out.println("4. Поиск книг на автору");
            System.out.println("5. Поиск книги на названию");
            System.out.println("6. Завершение работы");
            System.out.println("-------------------------");

            int userChoice = UserInputStatic.inputInt("Выберите вид операции:");

            switch (userChoice) {
                case 1 -> addNewBook();
                case 2 -> printLibraryInfo();
                case 3 -> findBookByCatalogNumber();
                case 4 -> findBooksByAuthor();
                case 5 -> findBooksByTitle();
                case 6 -> {
                    System.out.println("Завершение работы с системой.");
                    whileNotExit = false;
                }
                default -> System.out.println("Номер операции введен не правильно.");
            }
         }
    }

    private void addNewBook() {
        String bookId = UserInputStatic.inputText("Введите номер каталога книги: ");
        String bookTitle = UserInputStatic.inputText("Введите название книги: ");
        String bookAuthor = UserInputStatic.inputText("Введите автора книги: ");
        Book book = new Book(bookId, bookTitle, bookAuthor);
        if (bookService.addNewBook(book)) {
            System.out.println("Книга добавлена успешно");
        } else {
            System.out.println("Ошибка добавления. Нет свободного места или данное имя уже присутствует.");
        }
    }

    private void printLibraryInfo() {
        System.out.println(" -------- полный список книг ------------");
        Book[] allBooks = bookService.findAllBooks();
        for (Book currentBook : allBooks) {
            System.out.print("Номер каталога: " + currentBook.getBookId());
            System.out.print(", Автор книги: " + currentBook.getAuthor());
            System.out.print(", Название книги: " + currentBook.getTitle());
            System.out.println();
        }
    }

    private void findBookByCatalogNumber() {
        String bookIdSearch = UserInputStatic.inputText("Книгу с каким номером каталога нужно найти:");
        Book[] allBooks = bookService.findAllBooks();
        boolean isNotFound = true;
        for (Book currentBook : allBooks) {
            if (currentBook.getBookId().equals(bookIdSearch)) {
                isNotFound = false;
                System.out.println("Нашли книгу по поиску:");
                System.out.print("Номер каталога: " + currentBook.getBookId());
                System.out.print(", Автор книги: " + currentBook.getAuthor());
                System.out.print(", Название книги: " + currentBook.getTitle());
                System.out.println();
            }
        }
        if (isNotFound) {
            System.out.println("Книги в каталоге с номером: " + bookIdSearch + " не найдено");
        }
    }

    private void findBooksByAuthor() {
        String bookAuthorSearch = UserInputStatic.inputText("Книги какого автора нужно найти:");
        Book[] allBooks = bookService.findAllBooks();
        boolean isNotFind = true;
        for (Book currentBook : allBooks) {
            if (currentBook.getAuthor().toLowerCase().contains(bookAuthorSearch.toLowerCase())) {
                isNotFind = false;
                System.out.println("Нашли книгу по поиску:");
                System.out.print("Номер каталога: " + currentBook.getBookId());
                System.out.print(", Автор книги: " + currentBook.getAuthor());
                System.out.print(", Название книги: " + currentBook.getTitle());
                System.out.println();
            }
        }

        if (isNotFind) {
            System.out.println("Книги автора: " + bookAuthorSearch + " не найдены");
        }
    }

    private void findBooksByTitle() {
        String bookTitleSearch = UserInputStatic.inputText("Книгу с каким названием нужно найти:");
        Book[] allBooks = bookService.findAllBooks();
        boolean isNotFind = true;
        for (Book currentBook : allBooks) {
            if (currentBook.getTitle().equals(bookTitleSearch)) {
                isNotFind = false;
                System.out.println("Нашли книгу по поиску:");
                System.out.print("Номер каталога: " + currentBook.getBookId());
                System.out.print(", Автор книги: " + currentBook.getAuthor());
                System.out.print(", Название книги: " + currentBook.getTitle());
                System.out.println();
            }
        }
        if (isNotFind) {
            System.out.println("Книга с названием: " + bookTitleSearch + " не найдена");
        }
    }

}
