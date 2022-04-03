package com.example.demo.ratecomment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;


@Component
public class CommentService {

    private static CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public static List<Comments> getComments(){

        return commentRepository.findAll();
    }

    public static void addNewComment(Comments comment) {
        commentRepository.save(comment);
    }

    public static void deleteComment(Long commentId) {
        boolean exists = commentRepository.existsById(commentId);
        if (!exists){
            throw new IllegalStateException("no such comment");
        }
        commentRepository.deleteById(commentId);
    }
}
