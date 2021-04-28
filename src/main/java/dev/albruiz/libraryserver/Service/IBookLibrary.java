package dev.albruiz.libraryserver.Service;

import dev.albruiz.libraryserver.Model.Author;
import dev.albruiz.libraryserver.Model.Book;

import java.util.List;

public interface IBookLibrary  {
    List<Book> getBooks();
    Book findBook(String name);
    Book addBook(String bookName, String authorName);
}
