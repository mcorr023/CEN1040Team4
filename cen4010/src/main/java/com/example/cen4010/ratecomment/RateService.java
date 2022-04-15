package com.example.demo.ratecomment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RateService {

    private static RateRepository rateRepository;
    private static CommentRepository commentRepository;

    @Autowired
    public RateService(RateRepository rateRepository, CommentRepository commentRepository) {
        this.rateRepository = rateRepository;
        this.commentRepository = commentRepository;
    }

    public static List<Ratings> getRatings(){

        return rateRepository.findAll();

    }

    public static void addNewRating(Ratings rate) {
        rateRepository.save(rate);
        commentRepository.save(rate.getComment());
    }

    public static void deleteRating(Long rateId) {
        boolean exists = rateRepository.existsById(rateId);
        if (!exists){
            throw new IllegalStateException("no such rating");
        }
        rateRepository.deleteById(rateId);
    }

    public static Double averageRating(String bookId) {

        if (rateRepository.findRatingByBook(bookId).isEmpty()) {
            throw new IllegalStateException("no ratings on this book");
        }
        return rateRepository.average(bookId);

    }

    public static List<Ratings> sortRating(String bookId) {
        if (rateRepository.findRatingByBook(bookId).isEmpty()){
            throw new IllegalStateException("no ratings on this book");
        }
        return rateRepository.sortRatingsDesc(bookId);
    }
}
