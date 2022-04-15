package com.example.demo.ratecomment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping (path = "api/v1/rate")

public class RateController {

    private final RateService rateservice;

    @Autowired
    public RateController(RateService rateservice) {
        this.rateservice = rateservice;
    }

    @GetMapping
    public List<Ratings> getRatings () {
        return rateservice.getRatings();
    }

    @PostMapping
    public void addNewRating (@RequestBody Ratings rate){
        if (rate.getUser_rating() > 5 || rate.getUser_rating() < 1){
            throw new IllegalStateException("rate from 1 - 5 only");
        }
        rateservice.addNewRating(rate);
    }

    @DeleteMapping(path = "{rateId}")
    public void deleteRating (@PathVariable("rateId") Long rateId){
        rateservice.deleteRating(rateId);
    }

    @GetMapping (path = "/average/{bookId}")
    public Double averageRating(@PathVariable("bookId") String bookId){
        return rateservice.averageRating(bookId);
    }

    @GetMapping (path = "/sort/{bookId}")
    public List<Ratings> sortRating(@PathVariable("bookId") String bookId){
        return rateservice.sortRating(bookId);
    }
}
