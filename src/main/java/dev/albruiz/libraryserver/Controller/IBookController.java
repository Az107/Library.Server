package dev.albruiz.libraryserver.Controller;

import dev.albruiz.libraryserver.Model.Book;
import dev.albruiz.libraryserver.Service.Exceptions.NotFoundException;

import java.util.List;

public interface IBookController {

    String addBook(Book book) throws NotFoundException;

    List<Book> getBooks();

    Book findBook(String bookName) throws NotFoundException;

}
