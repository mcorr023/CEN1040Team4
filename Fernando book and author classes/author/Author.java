package com.example.demo.author;

import java.time.LocalDate;

public class Author {
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
