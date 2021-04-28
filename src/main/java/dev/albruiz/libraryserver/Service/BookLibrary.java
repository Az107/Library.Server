package dev.albruiz.libraryserver.Service;

import dev.albruiz.libraryserver.Model.Author;
import dev.albruiz.libraryserver.Model.Book;
import dev.albruiz.libraryserver.dao.IDataHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookLibrary implements IBookLibrary{

    IAuthorLibrary authorLibrary;
    IDataHelper dataHelper;

    @Autowired
    BookLibrary(IAuthorLibrary authorLibrary,IDataHelper SimpleDataHelper){
        this.authorLibrary = authorLibrary;
        this.dataHelper = SimpleDataHelper;
    }

    @Override
    public List<Book> getBooks() {
        return dataHelper.getBooks();
    }

    @Override
    public Book findBook(String name) {
        return dataHelper.findBook(name);
    }

    @Override
    public Book addBook(String bookName, String authorName) {
        Author author = authorLibrary.findAuthor(authorName);
        Book book = new Book(bookName,author);
        dataHelper.addBook(book);
        return  book;
    }
}
