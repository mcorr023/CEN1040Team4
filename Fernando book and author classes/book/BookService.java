package com.example.demo.book;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookService {
    public List<Book> getBooks(){
        return List.of(
                new Book(
                        9780441172719L,
                        "Dune",
                        "Set on the desert planet Arrakis, Dune is the story of the boy Paul Atreides, heir" +
                                " to a noble family tasked with ruling an inhospitable world where the only thing of " +
                                "value is the “spice” melange, a drug capable of extending life and enhancing " +
                                "consciousness. Coveted across the known universe, melange is a prize worth killing for...." +
                                "When House Atreides is betrayed, the destruction of Paul’s family will set the boy on " +
                                "a journey toward a destiny greater than he could ever have imagined. And as he evolves " +
                                "into the mysterious man known as Muad’Dib, he will bring to fruition humankind’s most " +
                                "ancient and unattainable dream.",
                        09.89,
                        "Frank Herbert",
                        "Sci-Fi",
                        "Chilton Books",
                        1965,
                        0
                )
        );
    }
}
