package com.example.demo.ratecomment;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table
public class Comments {
    @Id
    @SequenceGenerator(
            name = "comment_sequence",
            sequenceName = "comment_sequence",
            allocationSize =  1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "comment_sequence")
    private long id;
    private String user_comment;
    private Timestamp timestamp;

    public Comments() {
    }

    public Comments(long id, String user_comment, Timestamp timestamp) {
        this.id = id;
        this.user_comment = user_comment;
        this.timestamp = timestamp;
    }

    public Comments(String user_comment) {
        this.user_comment = user_comment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUser_comment() {
        return user_comment;
    }

    public void setUser_comment(String user_comment) {
        this.user_comment = user_comment;
    }

    public Timestamp getTimestamp() {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", user_comment='" + user_comment + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
