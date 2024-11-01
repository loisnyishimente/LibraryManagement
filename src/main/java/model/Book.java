package model;

public class Book {
    private int id;
    private String title;
    private String author;
    private int availableCount;

    public Book(int id, String title, String author, int availableCount) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.availableCount = availableCount;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getAvailableCount() {
        return availableCount;
    }
}
