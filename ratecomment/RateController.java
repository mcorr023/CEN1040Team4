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
        if (rate.getUserRating() > 5 || rate.getUserRating() < 1){
            throw new IllegalStateException("rate from 1 - 5 only");
        }
        rateservice.addNewRating(rate);
    }

    @DeleteMapping(path = "{rateId}")
    public void deleteRating (@PathVariable("rateId") Long rateId){
        rateservice.deleteRating(rateId);
    }

    @RequestMapping (path = "/average/{bookId}")
    public List<Object> averageRating(@PathVariable("bookId") String bookId){
        return rateservice.average(bookId);
    }

    @RequestMapping (path = "/sort")
    public List<Ratings> sortRating(){
        return rateservice.sortRating();
    }
}
