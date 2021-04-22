package dev.albruiz.libraryserver.Controller.Old;

import dev.albruiz.libraryserver.Model.Author;
import dev.albruiz.libraryserver.Model.Book;
import dev.albruiz.libraryserver.Model.User;
import dev.albruiz.libraryserver.Service.Library;

public interface IAddController {

    User addUser(String userName);
    Book addBook(String bookName, String authorName);
    Author addAuthor(String authorName, int year);
}
