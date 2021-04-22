package dev.albruiz.libraryserver.Controller.Old;


import dev.albruiz.libraryserver.Model.Author;
import dev.albruiz.libraryserver.Model.Book;
import dev.albruiz.libraryserver.Model.User;
import dev.albruiz.libraryserver.Service.ILibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Find")
public class FindController implements IFindController, IGetController {


    @Autowired
    FindController(@Qualifier("libraryDB")  ILibrary library){
        this.library = library;
    }

    ILibrary library;

    @GetMapping("/")
    public String root(){
        return "Find Working ✅";
    }

    @Override
    @GetMapping("/user/{userName}")
    public User findUser(@PathVariable String userName) {
        return library.findUser(userName);
    }

    @Override
    @GetMapping("/book/{bookName}")
    public Book findBook(@PathVariable String bookName) {
        return library.findBook(bookName);
    }

    @Override
    @GetMapping("/author/{authorName}")
    public Author findAuthor(@PathVariable String authorName) {
        return library.findAuthor(authorName);
    }

    @Override
    @GetMapping("/user")
    public User[] getUsers() {
        return library.getUsers();
    }

    @Override
    @GetMapping("/book")
    public Book[] getBooks() {
        return library.getBooks();
    }

    @Override
    @GetMapping("/author")
    public Author[] getAuthor() {
        return library.getAuthors();
    }
}
