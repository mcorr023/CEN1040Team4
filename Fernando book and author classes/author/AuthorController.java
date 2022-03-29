package com.example.demo.author;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/author")
public class AuthorController {

    @GetMapping
    public List<Author> getAuthors(){
        return List.of(
                new Author(
                        1L,
                        "Frank",
                        "Herbert",
                        "Sci-fi looking dude",
                        LocalDate.of(1920, Month.OCTOBER, 8)
                )
        );
    }


}
