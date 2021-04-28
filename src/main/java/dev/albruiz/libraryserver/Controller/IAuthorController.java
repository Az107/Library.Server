package dev.albruiz.libraryserver.Controller;

import dev.albruiz.libraryserver.Model.Author;

import java.util.List;

public interface IAuthorController {
    Author addAuthor(String authorName, int year);
    Author findAuthor(String authorName);
    List<Author> getAuthor();


}
