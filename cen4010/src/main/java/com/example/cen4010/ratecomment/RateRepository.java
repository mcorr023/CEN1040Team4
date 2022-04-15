package com.example.demo.ratecomment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface RateRepository extends JpaRepository<Ratings,Long> {

    @Query("SELECT s FROM Ratings s WHERE s.book_id = ?1")
    Optional<Ratings> findRatingByBook(String bookId);

    @Query("SELECT AVG(s.user_rating) FROM Ratings s WHERE s.book_id = ?1")
    Double average(String bookId);

    @Query("SELECT s FROM Ratings s WHERE s.book_id IN (?1) ORDER BY user_rating DESC")
    List<Ratings> sortRatingsDesc(String bookId);
}
