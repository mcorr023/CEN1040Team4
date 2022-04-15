import com.example.demo.author.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/getBooks")
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    @RequestMapping("/{isbn}")
    public List<Book> getBookByIsbn(@PathVariable Long isbn){
        return bookService.getBookByIsbn(isbn);
    }

    @PostMapping("/addBook")
    public void registerNewBook(@RequestBody Book book){
        bookService.addNewBook(book);
    }

    @DeleteMapping(path = "{bookIsbn}")
    public void deleteBook(@PathVariable("bookIsbn") Long isbn) {
        bookService.deleteBook(isbn);
    }
}
