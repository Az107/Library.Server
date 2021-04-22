package dev.albruiz.libraryserver.Service;

import dev.albruiz.libraryserver.Model.Book;
import dev.albruiz.libraryserver.Model.User;

public interface IUserLibrary extends ILibrary{

    User[] getUsers();
    User findUser(String name);
    User rentBook(User user, Book book);
    User returnBook(User user,Book book);
    User addUser(String userName);
}
