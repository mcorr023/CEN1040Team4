package com.example.demo.author;

import com.example.demo.book.Book;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class Author {

    @Id
    @SequenceGenerator(
            name = "author_sequence",
            sequenceName = "author_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "author_sequence"
    )

    private Long id;
    private String first_name;
    private String last_name;
    private String bio;
    private LocalDate dob;


    public Author() {
    }

    public Author(Long id, String first_name, String last_name, String bio, LocalDate dob) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.bio = bio;
        this.dob = dob;
    }

    public Author(String first_name, String last_name, String bio, LocalDate dob) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.bio = bio;
        this.dob = dob;
    }

    @OneToMany(targetEntity = Author.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "book_fk", referencedColumnName = "id")
    private List<Author> authors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Author {" +
                "id =" + id +
                ", name ='" + first_name + last_name + '\'' +
                ", biography =" + bio + '\'' +
                ", dob =" + dob +
                '}';
    }
}
