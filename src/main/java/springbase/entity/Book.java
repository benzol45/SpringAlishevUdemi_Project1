package springbase.entity;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class Book {
    private int id;
    @NotBlank(message = "You must type author")
    private String author;
    @NotBlank(message = "You must type book title")
    private String title;
    @Min(value = 1000, message = "Incorrect year")
    @Max(value = 3000, message = "Incorrect year")
    private int year;

    public Book() {
    }

    public Book(int id, String author, String title, int year) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
