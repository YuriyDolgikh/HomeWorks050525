package lesson06.task02;

public class Book {
    private String title;
    private String author;
    private boolean isIssued;

    public Book(String title, String author, boolean isIssued) {
        this.title = title;
        this.author = author;
        this.isIssued = isIssued;
    }

    public void setIsIssued(boolean isIssued) {
        this.isIssued = isIssued;
        System.out.println("Book status was set to: " + (this.isIssued ? "issued" : "not issued"));
    }

    public void printInfo() {
        System.out.println("Title: " + this.title);
        System.out.println("Author: " + this.author);
        System.out.println("Is issued: " + (this.isIssued ? "yes" : "no"));
        System.out.println("__________________________________________");
    }
}
