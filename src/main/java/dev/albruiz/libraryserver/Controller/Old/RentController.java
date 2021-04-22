package dev.albruiz.libraryserver.Controller.Old;


import dev.albruiz.libraryserver.Model.Book;
import dev.albruiz.libraryserver.Model.User;
import dev.albruiz.libraryserver.Service.ILibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Rent")
public class RentController implements IRentController {

    @Autowired
    RentController(@Qualifier("libraryDB") ILibrary library){
        this.library = library;
    }

    ILibrary library;

    @GetMapping("/")
    public String root(){
        return "Rent Working ✅";
    }

    @Override
    @GetMapping("/rent/{userName}/{bookName}") //TODO: change to POST
    @ResponseBody
    public User RentBook(@PathVariable String bookName,@PathVariable  String userName) {
        User user = library.findUser(userName);
        Book book = library.findBook(bookName);


        if (user != null && book != null){
            return  library.rentBook(user,book);
        }
        return  null;
    }

    @Override
    @GetMapping("/return/{userName}/{bookName}") //TODO: change to POST
    @ResponseBody
    public User ReturnBook(@PathVariable String bookName, @PathVariable String userName) {
        User user = library.findUser(userName);
        Book book = library.findBook(bookName);


        if (user != null && book != null){
            return  library.returnBook(user,book);
        }
        return  null;
    }
}
