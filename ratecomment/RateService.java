package com.example.demo.ratecomment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RateService{

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

    public static List<Ratings> sortRating() {
        return rateRepository.findAll(Sort.by("userRating").descending().and(Sort.by("bookId")));
    }

    public List<Object> average(String bookId) {
        if (rateRepository.findRatingByBook(bookId).isEmpty()) {
            throw new IllegalStateException("no ratings on this book");
        }
        return rateRepository.average(bookId);
    }
}
