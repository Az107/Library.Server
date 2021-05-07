package dev.albruiz.libraryserver.Service;

import dev.albruiz.libraryserver.Model.User;
import dev.albruiz.libraryserver.Service.Exceptions.NotFoundException;

import java.util.List;

public interface IUserService {

    List<User> getUsers();

    User findUser(String name) throws NotFoundException;

    User rentBook(String userName, String bookName) throws NotFoundException;

    User returnBook(String userName, String bookName) throws NotFoundException;

    void addUser(String userName);
}
