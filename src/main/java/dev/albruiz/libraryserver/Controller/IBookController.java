package dev.albruiz.libraryserver.Controller;

import dev.albruiz.libraryserver.Model.Book;

public interface IBookController {

    Book addBook(String bookName, String authorName);
    Book[] getBooks();
    Book findBook(String bookName);

}
