package dev.albruiz.libraryserver.Service;

import dev.albruiz.libraryserver.Model.Author;
import dev.albruiz.libraryserver.Model.Book;
import dev.albruiz.libraryserver.Model.User;

import java.util.ArrayList;
import java.util.List;

public interface ILibrary {

    Book[] getBooks();
    Author[] getAuthors();
    User[] getUsers();

    User findUser(String name);
    Book findBook(String name);
    Author findAuthor(String name);

    User rentBook(User user,Book book);
    User returnBook(User user,Book book);

    User addUser(String userName);
    Book addBook(String bookName, Author author);
    Author addAuthor(String authorName, int year);
}
