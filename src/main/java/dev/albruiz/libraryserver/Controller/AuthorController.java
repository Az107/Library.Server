package dev.albruiz.libraryserver.Controller;

import dev.albruiz.libraryserver.Model.Author;
import dev.albruiz.libraryserver.Service.ILibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("Author")
public class AuthorController implements IAuthorController {

    @Autowired
    AuthorController(@Qualifier("libraryDB") ILibrary library){
        this.library = library;
    }

    ILibrary library;

    @Override
    @PostMapping("/add")
    public Author addAuthor(@RequestBody String authorName, int year) {
        return library.addAuthor(authorName, year);
    }

    @Override
    @GetMapping("/{authorName}")
    @ResponseBody
    public Author findAuthor(@PathVariable String authorName) {
        return library.findAuthor(authorName);
    }

    @Override
    @GetMapping("/")
    @ResponseBody
    public Author[] getAuthor() {
        return library.getAuthors();
    }
}
