package com.library.Library.domain;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table (name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Size(min=2, message = "Tytuł musi posiadać co najmniej 2 litery")
    @Column (name = "book_title")
    private String title;

    @Column(name = "year", nullable = false)
    @NotNull(message="Rok nie może być pusty")
    @Range(min=1,max=9999, message="Błędny rok")
    private Integer year;

    @NotNull
    @Size(min=2, message = "Wydawca musi posiadać co najmniej 2 litery")
    private String publisher;

    @NotNull
    @Size(min=10, max=13, message = "ISBN musi posiadać co najmniej 10 znaków i nie więcej niż 13")
    private String isbn;

    @OneToOne
    @Valid
    Author author;

    public Book(String title, Integer year, String publisher, String isbn, Author author) {
        this.title = title;
        this.year = year;
        this.publisher = publisher;
        this.isbn = isbn;
        this.author = author;
    }

    public Book() { }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", publisher='" + publisher + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
