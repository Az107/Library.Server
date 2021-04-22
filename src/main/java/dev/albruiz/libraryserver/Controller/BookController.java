package dev.albruiz.libraryserver.Controller;

import dev.albruiz.libraryserver.Model.Author;
import dev.albruiz.libraryserver.Model.Book;
import dev.albruiz.libraryserver.Service.ILibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Book")
public class BookController implements IBookController{


    @Autowired
    BookController(@Qualifier("libraryDB") ILibrary library){
        this.library = library;
    }

    ILibrary library;


    @Override
    @PostMapping("/add/")
    @ResponseBody
    public Book addBook(@RequestBody String bookName, String authorName) {
        Author author = library.findAuthor(authorName);
        return library.addBook(bookName,author );

    }

    @Override
    @GetMapping("/")
    @ResponseBody
    public Book[] getBooks() {
        return library.getBooks();
    }

    @Override
    @GetMapping("/{bookName}")
    @ResponseBody
    public Book findBook(@PathVariable String bookName) {
        return library.findBook(bookName);
    }
}
