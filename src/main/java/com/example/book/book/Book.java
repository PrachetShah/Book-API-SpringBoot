package com.example.book.book;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Book {
    @Id
    @SequenceGenerator(
        name="book_sequence",
        sequenceName = "book_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "book_sequence"
    )
    private Long id;
    private String bookName;
    private String author;
    private String publication;
    private LocalDate publishDate;
    
    public Book() {
    }
    
    public Book(String bookName, String author, String publication, LocalDate publishDate) {
        this.bookName = bookName;
        this.author = author;
        this.publication = publication;
        this.publishDate = publishDate;
    }

    public Book(Long id, String bookName, String author, String publication, LocalDate publishDate) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.publication = publication;
        this.publishDate = publishDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Book{"+"id="+id+", name of book="+bookName+", author="+author+", publication="+publication+", publish date="+publishDate+"}";
    } 
}
