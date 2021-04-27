package dev.albruiz.libraryserver.Service;

import dev.albruiz.libraryserver.Model.Author;
import dev.albruiz.libraryserver.Model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookLibrary implements IBookLibrary{

    @Autowired
    BookLibrary(IAuthorLibrary authorLibrary){this.authorLibrary = authorLibrary;}

    IAuthorLibrary authorLibrary;

    List<Book> books = new ArrayList<>();

    @Override
    public Book[] getBooks() {
        return this.books.toArray(new Book[this.books.size()]);
    }

    @Override
    public Book findBook(String name) {
        for (Book book: books) {
            if (book.getName().equals(name)) return book;
        }
        return null;
    }

    @Override
    public Book addBook(String bookName, String authorName) {
        Author author = authorLibrary.findAuthor(authorName);
        Book book = new Book(bookName,author);
        books.add(book);
        return  book;
    }
}
