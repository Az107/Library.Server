package dev.albruiz.libraryserver.Service;

import dev.albruiz.libraryserver.Model.*;
import dev.albruiz.libraryserver.dao.IDataHelper;
import dev.albruiz.libraryserver.dao.MongoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LibraryDB implements ILibrary {

    private IDataHelper mongoHelper;

    @Autowired
    public LibraryDB(IDataHelper mongoHelper){
        this.mongoHelper = mongoHelper;
    }

    @Override
    public Book[] getBooks() {
        return this.mongoHelper.getBooks().toArray(new Book[0]);
    }

    @Override
    public Author[] getAuthors() {
        return this.mongoHelper.getAuthors().toArray(new Author[0]);
    }

    @Override
    public User[] getUsers() {
        return this.mongoHelper.getUsers().toArray(new User[0]);
    }


    @Override
    public User findUser(String name) {
        return mongoHelper.findUser(name);
    }

    @Override
    public Book findBook(String name) {
        return  mongoHelper.findBook(name);
    }

    @Override
    public Author findAuthor(String name) {
         return  mongoHelper.findAuthor(name);
    }


    @Override
    public User rentBook(User user, Book book) {
        user.addBook(book);
        mongoHelper.addBooktoUser(user.getName(),(Book) book);
        return user;
    }

    @Override
    public User returnBook(User user, Book book) {
        return null;
    }


    @Override
    public User addUser(String userName) {
        User user = new User(userName);
        this.mongoHelper.addUser(user);
        return user;
    }

    @Override
    public Book addBook(String bookName, Author author) {
        Book book = new Book(bookName,author);
        this.mongoHelper.addBook(book);
        return book;
    }

    @Override
    public Author addAuthor(String authorName, int year) {
        Author author = new Author(authorName,year);
        this.mongoHelper.addAuthors(author);
        return author;
    }
}
