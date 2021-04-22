package dev.albruiz.libraryserver.Controller.Old;

import dev.albruiz.libraryserver.Model.Author;
import dev.albruiz.libraryserver.Model.Book;
import dev.albruiz.libraryserver.Model.User;
import dev.albruiz.libraryserver.Service.ILibrary;
import dev.albruiz.libraryserver.Service.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Add")
public class AddController implements IAddController{

    @Autowired
    AddController(@Qualifier("libraryDB") ILibrary library){
        this.library = library;
    }

    ILibrary library;

    @GetMapping("/")
    public String root(){
        return "Add Working ✅";
    }

    @Override
    @GetMapping("/User/{userName}") //TODO: change to POST
    @ResponseBody
    public User addUser(@PathVariable String userName) {
        return this.library.addUser(userName);

    }


    @Override
    @GetMapping("/Book/{authorName}/{bookName}") //TODO: change to POST
    @ResponseBody
    public Book addBook(@PathVariable String bookName, @PathVariable String authorName) {
        Author author = library.findAuthor(authorName);
        if (author != null){
            return library.addBook(bookName, author);
        }else{return null;}


    }

    @Override
    @GetMapping("/Author/{year}/{authorName}")  //TODO: change to POST
    @ResponseBody
    public Author addAuthor(@PathVariable String authorName,@PathVariable int year) {
        return library.addAuthor(authorName,year);
    }
}
