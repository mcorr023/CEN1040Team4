package com.example.demo.ratecomment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping (path = "api/v1/comment")

public class CommentController {

    private final CommentService commentservice;

    @Autowired
    public CommentController(CommentService commentservice) {
        this.commentservice = commentservice;
    }
    @GetMapping
    public List<Comments> getComments () {
        return CommentService.getComments();
    }

    @PostMapping
    public void newComment (@RequestBody Comments comment){
        CommentService.addNewComment(comment);
    }

    @DeleteMapping (path = "{commentId}")
    public void deleteComment (@PathVariable("commentId") Long commentId){
        CommentService.deleteComment(commentId);
    }
}