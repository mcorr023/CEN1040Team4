package com.example.demo.author;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class AuthorConfig {

    @Bean
    CommandLineRunner commandLineRunner2(AuthorRepository repository){
        return args -> {
            Author frankherbert = new Author(
                            "Frank",
                            "Herbert",
                            "Sci-fi looking dude",
                            LocalDate.of(1920, Month.OCTOBER, 8)
                    );

            repository.saveAll(
                    List.of(frankherbert)
            );
        };
    }
}
