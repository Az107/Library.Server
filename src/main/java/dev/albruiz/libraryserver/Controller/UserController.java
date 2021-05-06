package dev.albruiz.libraryserver.Controller;

import dev.albruiz.libraryserver.Model.User;
import dev.albruiz.libraryserver.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("User")
public class UserController implements IUserController{

    @Autowired
    UserController(IUserService userService){
        this.service = userService;
    }
    IUserService service;



    @PostMapping("/add")
    @Override
    @ResponseBody
    public User addUser(@RequestBody String userName) {
        return service.addUser(userName);
    }

    @Override
    @GetMapping("/")
    @ResponseBody
    public List<User> getUsers() {
        return service.getUsers();
    }

    @Override
    @GetMapping("/{userName}/Rent/{bookName}")
    public User RentBook(@PathVariable String bookName,@PathVariable String userName) {
        return  service.rentBook(userName,bookName);
    }

    @Override
    @GetMapping("/{userName}/Return/{bookName}")
    public User ReturnBook(@PathVariable String bookName,@PathVariable String userName) {
        return  service.returnBook(userName,bookName);

    }

    @Override
    @GetMapping("/{userName}")
    @ResponseBody
    public User findUser(@PathVariable String userName) {
        return service.findUser(userName);
    }
}
