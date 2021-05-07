package dev.albruiz.libraryserver.Controller;

import dev.albruiz.libraryserver.Model.Author;
import dev.albruiz.libraryserver.Service.Exceptions.NotFoundException;
import dev.albruiz.libraryserver.Service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("Author")
public class AuthorController implements IAuthorController {

    @Autowired
    AuthorController(IAuthorService AuthorService) {
        this.service = AuthorService;
    }

    IAuthorService service;

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Data requested not found")
    void NotFoundHandler() {
    }

    @Override
    @PostMapping("/add")
    public String addAuthor(@RequestBody Author author) {

        return "ok ✅";
    }


    @Override
    @GetMapping("/{authorName}")
    @ResponseBody
    public Author findAuthor(@PathVariable String authorName) throws NotFoundException {
        return service.findAuthor(authorName);
    }

    @Override
    @GetMapping("/")
    @ResponseBody
    public List<Author> getAuthor() {
        return service.getAuthors();
    }


    static class authorParams{
            public String getName() {
                return Name;
            }

            public void setName(String name) {
                Name = name;
            }

            public int getYear() {
                return Year;
            }

            public void setYear(int year) {
                Year = year;
            }

            String Name;
            int Year;

            authorParams(String name,int year){
                Name = name;
                Year = year;
            }
    }
}
