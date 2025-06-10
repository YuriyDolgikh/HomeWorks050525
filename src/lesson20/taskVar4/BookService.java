package lesson20.taskVar4;

public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public boolean addNewBook(Book newBook) {
        // цель этого метода передать полученную книгу в репозиторий для сохранения
        // если у нас НЕТ никаких требований к содержимому полей новой книги
        // то функционал этого метода - просто обратится к репозиторию и получить
        // результат операции save()
        // но как правило ВСЕГДА будут требования, которые нужно будет проверить
        // ПРЕЖДЕ ЧЕМ обращаться в репозиторий
        // например:
        // - убедиться, что содержимое полей удовлетворяет критериям (не пустая и тд)
        // - убедиться, что такого id еще нет (потому, что это уникальный параметр)
        // - убедиться, что такого названия еще нет (потому, что это уникальный параметр)
        // и, только если это соблюдается, обратится в репозиторий для сохранения данных

        if (validateNewBook(newBook)) {
            return bookRepository.save(newBook);
        } else {
            return false;
        }

    }

    private boolean validateNewBook(Book newBook) {
        if (newBook.getBookId().isBlank()) {
            return false;
        }
        if (newBook.getAuthor().isBlank()) {
            return false;
        }
        if (newBook.getTitle().isBlank()) {
            return false;
        }

        if (bookRepository.findByBookId(newBook.getBookId()) != null) {
            // если мы обратились в репозиторий и попросили найти нам книгу из УЖЕ имеющихся
            // с id который указан в нашей новой книге
            // и репозиторий вернул нам ссылку на какой-то объект (все-равно какой, но не null),
            // то это значит, что СУЩЕСТВЕТ УЖЕ объект (книга), в котором в поле bookID
            // указан такой же номер каталога, как в нашей новой книге - а это значит
            // что мы НЕ МОЖЕМ создать (сохранить) нашу новую книгу в репозиторий

            return false;
        }

        if (bookRepository.findByBookTitle(newBook.getTitle()) != null) {
            // аналогично для поля "название"
            return false;
        }

        return true;
    }

    // написать сервисные методы для ПОИСКА по ID, автору и названию

    public Book findBookById(String bookId){
        // сейчас никакой ДОПОЛНИТЕЛЬНОЙ логики нам не нужно - просто возвращаем
        // результат работы репозитория
        // потом будем добавлять дополнительную логику

        return bookRepository.findByBookId(bookId);
    }

    public Book findBookByTitle(String title){

        return bookRepository.findByBookTitle(title);
    }

    public Book[] findBooksByAuthor(String author){

        return bookRepository.findByBookAuthor(author);
    }

    public Book[] findAllBooks(){
        return bookRepository.getAllBooks();
    }

}
