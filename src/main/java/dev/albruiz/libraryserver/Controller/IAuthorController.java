package dev.albruiz.libraryserver.Controller;

import dev.albruiz.libraryserver.Model.Author;
import dev.albruiz.libraryserver.Service.Exceptions.NotFoundException;

import java.util.List;

public interface IAuthorController {
    String addAuthor(Author author);

    Author findAuthor(String authorName) throws NotFoundException;

    List<Author> getAuthor();


}
