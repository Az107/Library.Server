package dev.albruiz.libraryserver.Controller;

import dev.albruiz.libraryserver.Model.Author;
import dev.albruiz.libraryserver.Model.Book;
import dev.albruiz.libraryserver.Service.IBookLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Book")
public class BookController implements IBookController {


    @Autowired
    BookController(IBookLibrary bookLibrary){
        this.booklibrary = bookLibrary;
    }

    IBookLibrary booklibrary;

    @Override
    @PostMapping("/add/")
    @ResponseBody
    public Book addBook(@RequestBody String bookName, String authorName) {
        return booklibrary.addBook(bookName,authorName );

    }

    @Override
    @GetMapping("/")
    @ResponseBody
    public List<Book> getBooks() {
        return booklibrary.getBooks();
    }

    @Override
    @GetMapping("/{bookName}")
    @ResponseBody
    public Book findBook(@PathVariable String bookName) {
        return booklibrary.findBook(bookName);
    }
}
