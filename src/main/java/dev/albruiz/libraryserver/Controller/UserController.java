package dev.albruiz.libraryserver.Controller;

import dev.albruiz.libraryserver.Model.User;
import dev.albruiz.libraryserver.Service.Exceptions.NotFoundException;
import dev.albruiz.libraryserver.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("User")
public class UserController implements IUserController {

    @Autowired
    UserController(IUserService userService) {
        this.service = userService;
    }

    IUserService service;

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Data requested not found")
    void NotFoundHandler() {
    }


    @PostMapping("/add")
    @Override
    public String addUser(@RequestBody String userName) {
        return "ok ✅";
    }

    @Override
    @GetMapping("/")
    @ResponseBody
    public List<User> getUsers() {
        return service.getUsers();
    }

    @Override
    @GetMapping("/{userName}/Rent/{bookName}")
    public User RentBook(@PathVariable String bookName, @PathVariable String userName) throws NotFoundException {
        return service.rentBook(userName, bookName);
    }

    @Override
    @GetMapping("/{userName}/Return/{bookName}")
    public User ReturnBook(@PathVariable String bookName, @PathVariable String userName) throws NotFoundException {
        return service.returnBook(userName, bookName);

    }

    @Override
    @GetMapping("/{userName}")
    @ResponseBody
    public User findUser(@PathVariable String userName) throws NotFoundException {
        return service.findUser(userName);
    }
}
