package dev.albruiz.libraryserver.Controller.Old;

import dev.albruiz.libraryserver.Model.*;

public interface IGetController {

    User[] getUsers();
    Book[] getBooks();
    Author[] getAuthor();
}
