package com.example.cen4010.ratecommentfeature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (path = "api/v1/team4")
public class RateCommentController
{
    private final RateCommentService rcservice;

    @Autowired
    public RateCommentController(RateCommentService rcservice){
        this.rcservice = rcservice;
    }

    @GetMapping
    public void comments(){
        rcservice.userInput();
    }


}
