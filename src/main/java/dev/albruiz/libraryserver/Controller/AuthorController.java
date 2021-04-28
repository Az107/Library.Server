package dev.albruiz.libraryserver.Controller;

import dev.albruiz.libraryserver.Model.Author;
import dev.albruiz.libraryserver.Service.IAuthorLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("Author")
public class AuthorController implements IAuthorController {

    @Autowired
    AuthorController(IAuthorLibrary AuthorLibrary){
        this.library = AuthorLibrary;
    }

    IAuthorLibrary library;

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
    public List<Author> getAuthor() {
        return library.getAuthors();
    }
}
