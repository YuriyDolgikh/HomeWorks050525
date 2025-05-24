package lesson05.task01;

public class Book {

    String title;
    String author;
    int year;
    boolean isIssued;

    public Book(String title, String author, int year, boolean isIssued) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isIssued = isIssued;
    }

    public void printBookInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year: " + year);
        System.out.println("Is issued: " + (isIssued ? "Yes" : "No"));
    }
}
