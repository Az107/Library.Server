package dev.albruiz.libraryserver.Service;

import dev.albruiz.libraryserver.Model.Author;

public interface IAuthorLibrary extends ILibrary {
    Author[] getAuthors();
    Author findAuthor(String name);
    Author addAuthor(String authorName, int year);
}
