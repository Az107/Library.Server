package dev.albruiz.libraryserver.Service;

import dev.albruiz.libraryserver.Model.Author;
import dev.albruiz.libraryserver.Service.Exceptions.NotFoundException;

import java.util.List;

public interface IAuthorService {
    List<Author> getAuthors();

    Author findAuthor(String name) throws NotFoundException;

    void addAuthor(String authorName, int year);
}
