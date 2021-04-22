package dev.albruiz.libraryserver.Controller;

import dev.albruiz.libraryserver.Model.Author;

public interface IAuthorController {
    Author addAuthor(String authorName, int year);
    Author findAuthor(String authorName);
    Author[] getAuthor();


}