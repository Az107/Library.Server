package dev.albruiz.libraryserver.Service;

import dev.albruiz.libraryserver.Model.Author;
import dev.albruiz.libraryserver.Model.Book;

public interface IBookLibrary  {
    Book[] getBooks();
    Book findBook(String name);
    Book addBook(String bookName, String authorName);
}
