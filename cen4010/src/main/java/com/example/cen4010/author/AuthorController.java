package com.example.demo.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/author")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService){
        this.authorService = authorService;
    }


    @GetMapping("/getAuthors")
    public List<Author> getAuthors(){
        return authorService.getAuthors();
    }

    @PostMapping("/addAuthor")
    public void registerNewAuthor(@RequestBody Author author){authorService.addNewAuthor(author);}

    @DeleteMapping(path = "{authorId}")
    public void deleteAuthor(@PathVariable("authorId") Long id) {
        authorService.deleteAuthor(id);
    }


}
