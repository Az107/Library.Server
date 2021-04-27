package dev.albruiz.libraryserver.Service;

import dev.albruiz.libraryserver.Model.Author;

public interface IAuthorLibrary  {
    Author[] getAuthors();
    Author findAuthor(String name);
    Author addAuthor(String authorName, int year);
}
