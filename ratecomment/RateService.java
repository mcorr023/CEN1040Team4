package com.example.demo.ratecomment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RateService {

    private static RateRepository rateRepository;
    private static RateRepository repository;

    @Autowired
    public RateService(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    public static List<Ratings> getRatings(){

        return rateRepository.findAll();

    }

    public static void addNewRating(Ratings rate) {
        rateRepository.save(rate);
    }

    public static void deleteRating(Long rateId) {
        boolean exists = rateRepository.existsById(rateId);
        if (!exists){
            throw new IllegalStateException("no such rating");
        }
        rateRepository.deleteById(rateId);
    }

    public static double averageRating(String bookId) {

        if (rateRepository.findRatingByBook(bookId).isEmpty()) {
            throw new IllegalStateException("no ratings on this book");
        }
        return rateRepository.average(bookId);

    }

    public static void sortRating(String bookId) {
        while(rateRepository.findRatingByBook(bookId).isPresent()) {
            List<Ratings> bookRatings = rateRepository.findAll(Sort.by(Sort.Direction.DESC, "user_rating");
            System.out.println(bookRatings);
        }
        if (rateRepository.findRatingByBook(bookId).isEmpty()){
            throw new IllegalStateException("no ratings on this book");
        }
    }
}
