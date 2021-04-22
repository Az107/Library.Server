package dev.albruiz.libraryserver.Controller;

import dev.albruiz.libraryserver.Model.User;

public interface IUserController {
    User addUser(String userName);
    User[] getUsers();
    User RentBook(String bookName,String userName);
    User ReturnBook(String bookName,String UserName);
    User findUser(String userName);


}
