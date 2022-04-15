package com.example.demo.ratecomment;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table
public class Ratings {

    @Id
    private long id;
    private int user_rating;
    private String book_id;
    private Timestamp timestamp;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "comment_id", referencedColumnName = "id")
    @MapsId
    private Comments comment;

    public Ratings() {
    }

    public Ratings(long id, int user_rating, String book_id, Timestamp timestamp, Comments comment) {
        this.id = id;
        this.user_rating = user_rating;
        this.book_id = book_id;
        this.timestamp = timestamp;
        this.comment = comment;
    }

    public Ratings(int user_rating, String book_id, Comments comment) {
        this.user_rating = user_rating;
        this.book_id = book_id;
        this.comment = comment;
    }

    public long getId() { return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getUser_rating() {
            return user_rating;
    }

    public void setUser_rating(int user_rating) {
        this.user_rating = user_rating;
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
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
                ", user_rating=" + user_rating +
                ", book_id='" + book_id + '\'' +
                ", timestamp=" + timestamp +
                ", comment=" + comment +'}';
    }
}
