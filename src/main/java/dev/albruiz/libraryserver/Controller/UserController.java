package dev.albruiz.libraryserver.Controller;

import dev.albruiz.libraryserver.Model.Book;
import dev.albruiz.libraryserver.Model.User;
import dev.albruiz.libraryserver.Service.ILibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("User")
public class UserController implements IUserController{

    @Autowired
    UserController(@Qualifier("libraryDB") ILibrary library){
        this.library = library;
    }
    ILibrary library;



    @PostMapping("/add")
    @Override
    @ResponseBody
    public User addUser(@RequestBody String userName) {
        return library.addUser(userName);
    }

    @Override
    @GetMapping("/")
    @ResponseBody
    public User[] getUsers() {
        return library.getUsers();
    }

    @Override
    @GetMapping("/{userName}/Rent/{bookName}")
    public User RentBook(@PathVariable String bookName, String userName) {
        User user = library.findUser(userName);
        Book book = library.findBook(bookName);


        if (user != null && book != null){
            return  library.rentBook(user,book);
        }
        return  null;
    }

    @Override
    @GetMapping("/{userName}/Return/{bookName}")
    public User ReturnBook(@PathVariable String bookName, String userName) {
        User user = library.findUser(userName);
        Book book = library.findBook(bookName);


        if (user != null && book != null){
            return  library.returnBook(user,book);
        }
        return  null;
    }

    @Override
    @GetMapping("/{userName}")
    @ResponseBody
    public User findUser(@PathVariable String userName) {
        return library.findUser(userName);
    }
}
