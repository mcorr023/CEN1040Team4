package com.example.demo.ratecomment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RateRepository extends JpaRepository<Ratings,Long> {

    @Query("SELECT s FROM Ratings s WHERE s.bookId = ?1")
    Optional<Ratings> findRatingByBook(String bookId);

    @Query("SELECT AVG(s.userRating) FROM Ratings s WHERE s.bookId = ?1")
    List<Object> average(String bookId);

}
