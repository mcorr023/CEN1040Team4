package com.example.demo.book;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Book {
    @Id
//    @SequenceGenerator(
//            name = "book_sequence",
//            sequenceName = "book_sequence",
//            allocationSize = 1
//    )
//
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "book_sequence"
//    )

    private Long isbn;
    private String bookTitle;
    private String bookDescription;
    private Double bookPrice;
    private String genre;
    private String publisher;
    private String authorName;
    private Integer yearPublished;
    private Integer copiesSold;


    public Book() {
    }

    public Book(Long isbn,
                String bookTitle,
                String bookDescription,
                Double bookPrice,
                String authorName,
                String genre,
                String publisher,
                Integer yearPublished,
                Integer copiesSold) {
        this.isbn = isbn;
        this.bookTitle = bookTitle;
        this.bookDescription = bookDescription;
        this.bookPrice = bookPrice;
        this.authorName = authorName;
        this.genre = genre;
        this.publisher = publisher;
        this.yearPublished = yearPublished;
        this.copiesSold = copiesSold;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public Double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(Integer yearPublished) {
        this.yearPublished = yearPublished;
    }

    public Integer getCopiesSold() {
        return copiesSold;
    }

    public void setCopiesSold(Integer copiesSold) {
        this.copiesSold = copiesSold;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN=" + isbn +
                ", Title='" + bookTitle + '\'' +
                ", Description='" + bookDescription + '\'' +
                ", Price=" + bookPrice +
                ", Author= " + authorName +
                ", Genre='" + genre + '\'' +
                ", Publisher='" + publisher + '\'' +
                ", Year Published=" + yearPublished +
                ", Copies Sold=" + copiesSold +
                '}';
    }
}
