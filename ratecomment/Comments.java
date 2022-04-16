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
    private String userComment;
    private Timestamp timestamp;

    public Comments() {
    }

    public Comments(long id, String userComment, Timestamp timestamp) {
        this.id = id;
        this.userComment = userComment;
        this.timestamp = timestamp;
    }

    public Comments(String userComment) {
        this.userComment = userComment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserComment() {
        return userComment;
    }

    public void setUserComment(String user_comment) {
        this.userComment = userComment;
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
                ", userComment='" + userComment + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
