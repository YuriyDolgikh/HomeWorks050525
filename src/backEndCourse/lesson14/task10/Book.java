package backEndCourse.lesson14.task10;

import java.util.List;

public class Book {
    private final String title;
    private final String author;
    private final List<String> tags;

    public Book(String title, String author, List<String> tags) {
        this.title = title;
        this.author = author;
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public List<String> getTags() {
        return tags;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", tags=" + tags +
                '}';
    }
}
