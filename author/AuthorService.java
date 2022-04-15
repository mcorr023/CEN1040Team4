import com.example.demo.book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    public List<Author> getAuthors(){
        return authorRepository.findAll();
    }

    public void addNewAuthor(Author author) {
        Optional<Author> authorOptional = authorRepository.findAuthorById(author.getId());

        if (authorOptional.isPresent()){
            throw new IllegalStateException("Author is already present in the system.");
        }

        authorRepository.save(author);
    }

    public void deleteAuthor(Long id) {
        boolean exists = authorRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException(
                    "Author with ID # " + id + " does not exist.");
        }

        authorRepository.deleteById(id);
    }
}
