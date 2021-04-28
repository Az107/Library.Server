package dev.albruiz.libraryserver.Service;

import dev.albruiz.libraryserver.Model.Author;

import java.util.List;

public interface IAuthorLibrary  {
    List<Author> getAuthors();
    Author findAuthor(String name);
    Author addAuthor(String authorName, int year);
}
