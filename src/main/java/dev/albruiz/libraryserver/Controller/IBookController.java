package dev.albruiz.libraryserver.Controller;

import dev.albruiz.libraryserver.Model.Book;

import java.util.List;

public interface IBookController {

    Book addBook(String bookName, String authorName);
    List<Book> getBooks();
    Book findBook(String bookName);

}
