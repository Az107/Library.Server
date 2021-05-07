package dev.albruiz.libraryserver.Service;

import dev.albruiz.libraryserver.Model.Book;
import dev.albruiz.libraryserver.Service.Exceptions.NotFoundException;

import java.util.List;

public interface IBookService {
    List<Book> getBooks();

    Book findBook(String name) throws NotFoundException;

    void addBook(String bookName, String authorName) throws NotFoundException;
}
