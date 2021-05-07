package dev.albruiz.libraryserver.Controller;

import dev.albruiz.libraryserver.Model.User;
import dev.albruiz.libraryserver.Service.Exceptions.NotFoundException;

import java.util.List;

public interface IUserController {
    String addUser(String userName);

    List<User> getUsers();

    User RentBook(String bookName, String userName) throws NotFoundException;

    User ReturnBook(String bookName, String UserName) throws NotFoundException;

    User findUser(String userName) throws NotFoundException;


}
