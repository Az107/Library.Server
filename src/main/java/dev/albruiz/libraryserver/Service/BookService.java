package dev.albruiz.libraryserver.Service;

import dev.albruiz.libraryserver.Model.Author;
import dev.albruiz.libraryserver.Model.Book;
import dev.albruiz.libraryserver.Service.Exceptions.NotFoundException;
import dev.albruiz.libraryserver.dao.IDataHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {

    IDataHelper<Author> dataHelperAuthor;
    IDataHelper<Book> dataHelper;

    @Autowired
    BookService(IDataHelper<Book> dataHelper,IDataHelper<Author> dataHelperAuthor){
        this.dataHelperAuthor = dataHelperAuthor;
        this.dataHelper = dataHelper;
    }

    @Override
    public List<Book> getBooks() {
        return dataHelper.getAll();
    }

    @Override
    public Book findBook(String name) throws NotFoundException {
        Book book = dataHelper.find(name);
        if (book == null) throw new NotFoundException();
        return book;
    }

    @Override
    public void addBook(String bookName, String authorName) throws NotFoundException {
        Author author = dataHelperAuthor.find(authorName);
        if (author == null) throw new NotFoundException();
        Book book = new Book(bookName, author);
        dataHelper.add(book);
    }
}
