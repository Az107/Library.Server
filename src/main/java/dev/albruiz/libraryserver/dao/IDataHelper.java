package dev.albruiz.libraryserver.dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.result.UpdateResult;
import dev.albruiz.libraryserver.Model.Author;
import dev.albruiz.libraryserver.Model.Book;
import dev.albruiz.libraryserver.Model.User;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.push;

public interface IDataHelper {

    public Book findBook(String Name);

    public List<Book> getBooks();

    public void addBook(Book book);

    public List<Author> getAuthors();

    public Author findAuthor(String Name);

    public void addAuthors(Author author);

    public List<User> getUsers();

    public User findUser(String Name);

    public void addUser(User user);

    public void addBooktoUser(String userName,Book book);

}
