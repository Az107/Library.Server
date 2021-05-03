package dev.albruiz.libraryserver.Controller;

import dev.albruiz.libraryserver.Model.Author;
import dev.albruiz.libraryserver.Model.Book;
import dev.albruiz.libraryserver.Service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Book")
public class BookController implements IBookController {


    @Autowired
    BookController(IBookService bookService){
        this.service = bookService;
    }

    IBookService service;

    @Override
    @PostMapping("/add/")
    @ResponseBody
    public Book addBook(@RequestBody String bookName, String authorName) {
        return service.addBook(bookName,authorName );

    }

    @Override
    @GetMapping("/")
    @ResponseBody
    public List<Book> getBooks() {
        return service.getBooks();
    }

    @Override
    @GetMapping("/{bookName}")
    @ResponseBody
    public Book findBook(@PathVariable String bookName) {
        return service.findBook(bookName);
    }
}
