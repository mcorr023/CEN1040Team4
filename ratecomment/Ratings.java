package com.example.demo.ratecomment;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table
public class Ratings {

    @Id
    private long id;
    private int userRating;
    private String bookId;
    private Timestamp timestamp;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "commentId", referencedColumnName = "id")
    @MapsId
    private Comments comment;

    public Ratings() {
    }

    public Ratings(long id, int userRating, String bookId, Timestamp timestamp, Comments comment) {
        this.id = id;
        this.userRating = userRating;
        this.bookId = bookId;
        this.timestamp = timestamp;
        this.comment = comment;
    }

    public Ratings(int userRating, String bookId, Comments comment) {
        this.userRating = userRating;
        this.bookId = bookId;
        this.comment = comment;
    }

    public long getId() { return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getUserRating() {
            return userRating;
    }

    public void setUserRating(int userRating) {
        this.userRating = userRating;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public Timestamp getTimestamp() {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        return timestamp;
    }
    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Comments getComment() {
        return comment;
    }
    public void setComment(){
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Ratings{" +
                "id=" + id +
                ", userRating=" + userRating +
                ", bookId='" + bookId + '\'' +
                ", timestamp=" + timestamp +
                ", comment=" + comment +'}';
    }
}
