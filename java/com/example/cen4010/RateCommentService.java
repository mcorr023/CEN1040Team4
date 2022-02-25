package com.example.cen4010.ratecommentfeature;

import org.springframework.stereotype.Service;

import java.security.Timestamp;
import java.util.Date;

import static com.example.cen4010.ratecommentfeature.BookComment.showComment;
import static com.example.cen4010.ratecommentfeature.BookRating.showRating;

@Service
public class RateCommentService {
    public void userInput() {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                showComment();
                showRating();

                Date date = new Date();
                //Timestamp timestamp = new Timestamp(date.getTime());
                //System.out.println(timestamp);
            }
        });
    }
}
