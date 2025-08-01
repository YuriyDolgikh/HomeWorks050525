package backEndCourse.lesson14.task10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BooksApp {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Java for beginners", "Author1", Arrays.asList("Java", "Programming", "Spring")));
        books.add(new Book("Using Python", "Author2", Arrays.asList("Python", "Programming", "PRO")));
        books.add(new Book("Java for experts", "Author3", Arrays.asList("Java", "Projects", "Security")));
        books.add(new Book("Python for experts", "Author4", Arrays.asList("Python", "Projects", "Data Science")));

        List<String> uniqueTags = books.stream()
                .flatMap(book -> book.getTags().stream())
                .distinct()
                .toList();

        System.out.println(uniqueTags);
    }
}
