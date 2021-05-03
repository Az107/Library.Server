package dev.albruiz.libraryserver.Service;

import dev.albruiz.libraryserver.Model.Author;
import dev.albruiz.libraryserver.Model.Book;
import dev.albruiz.libraryserver.dao.IDataHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {

    IAuthorService authorService;
    IDataHelper<Book> dataHelper;

    @Autowired
    BookService(IAuthorService authorService, @Qualifier("simpleDataHelper") IDataHelper<Book> dataHelper){
        this.authorService = authorService;
        this.dataHelper = dataHelper;
    }

    @Override
    public List<Book> getBooks() {
        return dataHelper.getAll();
    }

    @Override
    public Book findBook(String name) {
        return dataHelper.find(name);
    }

    @Override
    public Book addBook(String bookName, String authorName) {
        Author author = authorService.findAuthor(authorName);
        Book book = new Book(bookName,author);
        dataHelper.add(book);
        return  book;
    }
}
