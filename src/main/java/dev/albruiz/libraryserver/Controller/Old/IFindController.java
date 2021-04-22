package dev.albruiz.libraryserver.Controller.Old;

import dev.albruiz.libraryserver.Model.Author;
import dev.albruiz.libraryserver.Model.Book;
import dev.albruiz.libraryserver.Model.User;

public interface IFindController {

    User findUser(String userName);
    Book findBook(String bookName);
    Author findAuthor(String authorName);
}
