package dev.albruiz.libraryserver.Service;

import dev.albruiz.libraryserver.Model.Book;
import dev.albruiz.libraryserver.Model.User;

public interface IUserLibrary {

    User[] getUsers();
    User findUser(String name);
    User rentBook(String userName, String bookName);
    User returnBook(String userName, String bookName);
    User addUser(String userName);
}
