package lesson20.taskVar4;

public class BookRepository {

    private Book[] library;
    private int currentQuantity = 0;

    public BookRepository(int librarySize) {
        this.library = new Book[librarySize];
    }

    public boolean save(Book book) {
        if (currentQuantity < library.length) {
            library[currentQuantity] = book;
            currentQuantity++;
            return true;
        } else {
            return false;
        }
    }


    public Book findByBookId(String bookIdSearch) {
        // проходимся по всем заполненным ячейкам массива
        for (int i = 0; i < currentQuantity; i++) {
            // берем ссылку на объект Book, которая хранится в текущей ячейки массива
            // идем по этой ссылке и берем у объекта содержимое поля bookId
            // сравниваем это содержимое с тем что мы ищем
            // если совпадает - то значит мы нашли нужную книгу
            // и как результат работы этого метода мы возвращаем
            // ссылку на объект Book в котором совпало значение поля bookId
            // а эта ссылка хранится в текущей ячейки массива

            if (library[i].getBookId().equals(bookIdSearch)) {
                return library[i];
            }
        }

        return null;
    }


    public Book findByBookTitle(String bookTitleSearch) {
        // проходимся по всем заполненным ячейкам массива
        for (int i = 0; i < currentQuantity; i++) {
            // берем ссылку на объект Book, которая хранится в текущей ячейки массива
            // идем по этой ссылке и берем у объекта содержимое поля title
            // сравниваем это содержимое с тем что мы ищем
            // если совпадает - то значит мы нашли нужную книгу
            // и как результат работы этого метода мы возвращаем
            // ссылку на объект Book в котором совпало значение поля title
            // а эта ссылка хранится в текущей ячейки массива

            if (library[i].getTitle().equals(bookTitleSearch)) {
                return library[i];
            }
        }

        return null;
    }


    public Book[] findByBookAuthor(String bookAuthorSearch) {
        // поскольку у нас может быть МНОГО книг одного автора
        // то наш метод возвращает не одну ссылку на Book, а возвращает ссылку
        // на новый массив в котором будут хранится ссылки на объекты класса Book
        // у которых значение в поле Author будет одинаковое - такое как мы ищем.
        // Но так как мы заранее НЕ ЗНАЕМ сколько именно книг такого автора у нас есть,
        // то мы вынуждены разбить решение этой задачи на две части
        // часть 1: пройдемся в цикле по ВСЕМ имеющимся у нас книгам и посчитаем количество
        // книг нужного нам автора
        // после этого СОЗДАДИМ новый массив такого размера - сколько книг нужного нам автора мы насчитали
        // для хранения ссылок книг одного автора
        // часть 2: опять пройдемся в цикле по ВСЕМ имеющимся у нас книгам и в случае если
        // текущая книга имеет автора, которого мы ищем - то добавим ссылку на эту книгу
        // в наш массив "найденных" книг одного автора

        int counterMatches = 0;

        for (int i = 0; i < currentQuantity; i++) {
            if (library[i].getAuthor().equals(bookAuthorSearch)) {
                counterMatches++;
            }
        }

        Book[] booksByAuthor = new Book[counterMatches];
        int booksByAuthorIndex = 0;

        // заполним этот массив

        for (int i = 0; i < currentQuantity; i++) {
            if (library[i].getAuthor().equals(bookAuthorSearch)) {
                // если в очередной книге из библиотеки автор - тот которого мы ищем
                // то нам надо ссылку на эту книгу положить в booksByAuthor
                // для этого нам нужно отдельно учитывать порядковые номера ячеек это массива
                booksByAuthor[booksByAuthorIndex] = library[i];
                booksByAuthorIndex++;
            }
        }

        return booksByAuthor;
    }

    public Book[] getAllBooks() {
        Book[] result = new Book[ currentQuantity];
        System.arraycopy(library, 0, result, 0, currentQuantity);
        return result;
    }

}
