package summary0606.library.entity;

public class Book {
    private static int nextId = 1;
    private int id;
    private String name;
    private String author;

    public Book(String name, String author) {
        this.id = nextId++;
        this.name = name;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }
}
