package com.example.demo.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    @Query ("SELECT b FROM Book b WHERE b.isbn = ?1")
    Optional<Book> findBookByIsbn(Long isbn);

    public List<Book> findBookDetailsByIsbn(Long isbn);

}
