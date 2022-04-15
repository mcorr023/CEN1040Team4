import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BookConfig {

    @Bean
    CommandLineRunner commandLineRunner(BookRepository repository){
        return args -> {
            Book dune = new Book(
                    9780441172719L,
                    "Dune",
                    "Dune is the story of the boy Paul Atreides, heir" + " to a noble family tasked with " +
                            "ruling an inhospitable world where the only thing of " +
                            "value is the “spice” melange, a drug capable of extending life and enhancing " +
                            "consciousness.",
                    09.89,
                    "Frank Herbert",
                    "Sci-Fi",
                    "Chilton Books",
                    1965,
                    0
            );

            repository.saveAll(
                    List.of(dune)
            );
        };
    }
}
