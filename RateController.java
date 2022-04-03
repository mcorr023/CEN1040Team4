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
        return RateService.getRatings();
    }

    @PostMapping
    public void newRating (@RequestBody Ratings rate){
        RateService.addNewRating(rate);
    }

    @DeleteMapping(path = "{rateId}")
    public void deleteRating (@PathVariable("rateId") Long rateId){
        RateService.deleteRating(rateId);
    }

    @GetMapping (path = "average/{bookId}")
    public void averageRating(@PathVariable("bookId") String bookId){
        RateService.averageRating(bookId);
    }

    @GetMapping (path = "sort/{bookId}")
    public void sortRating(@PathVariable("bookId") String bookId){
        RateService.sortRating(bookId);
    }
}
