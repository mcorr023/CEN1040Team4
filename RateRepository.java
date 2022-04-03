package com.example.demo.ratecomment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RateRepository extends JpaRepository<Ratings,Long> {

    @Query("SELECT s FROM Ratings s WHERE s.book_id = ?1")
    Optional<Ratings> findRatingByBook(String bookId);

    @Query("Select AVG(user_rating) FROM Ratings WHERE book_id = ?1")
    double average(String bookId);

}
