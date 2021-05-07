package dev.albruiz.libraryserver.Controller;

import dev.albruiz.libraryserver.Model.Book;
import dev.albruiz.libraryserver.Service.Exceptions.NotFoundException;
import dev.albruiz.libraryserver.Service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Book")
public class BookController implements IBookController {


    @Autowired
    BookController(IBookService bookService) {
        this.service = bookService;
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Data requested not found")
    void NotFoundHandler() {
    }

    IBookService service;

    @Override
    @PostMapping("/add/")
    @ResponseBody
    public String addBook(@RequestBody Book book) throws NotFoundException {
        if (book.getName() != null) service.addBook(book.getName(), book.getAuthor().getName());
        return "ok ✅";
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
    public Book findBook(@PathVariable String bookName) throws NotFoundException {
        return service.findBook(bookName);
    }
}
