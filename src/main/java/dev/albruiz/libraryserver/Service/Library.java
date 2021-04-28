package dev.albruiz.libraryserver.Service;

import dev.albruiz.libraryserver.Model.Author;
import dev.albruiz.libraryserver.Model.Book;
import dev.albruiz.libraryserver.Model.User;
import dev.albruiz.libraryserver.dao.IDataHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Library implements ILibrary {

    private IDataHelper simpleDataHelper;

    @Autowired
    public Library(IDataHelper SimpleDataHelper){
        this.simpleDataHelper = simpleDataHelper;
    }
    
    @Override
    public Book[] getBooks() {
        return this.simpleDataHelper.getBooks().toArray(new Book[0]);
    }

    @Override
    public Author[] getAuthors() {
        return this.simpleDataHelper.getAuthors().toArray(new Author[0]);
    }

    @Override
    public User[] getUsers() {
        return this.simpleDataHelper.getUsers().toArray(new User[0]);
    }


    @Override
    public User findUser(String name) {
        return simpleDataHelper.findUser(name);
    }

    @Override
    public Book findBook(String name) {
        return  simpleDataHelper.findBook(name);
    }

    @Override
    public Author findAuthor(String name) {
         return  simpleDataHelper.findAuthor(name);
    }


    @Override
    public User rentBook(User user, Book book) {
        user.addBook(book);
        simpleDataHelper.addBooktoUser(user.getName(),(Book) book);
        return user;
    }

    @Override
    public User returnBook(User user, Book book) {
        return null;
    }


    @Override
    public User addUser(String userName) {
        User user = new User(userName);
        this.simpleDataHelper.addUser(user);
        return user;
    }

    @Override
    public Book addBook(String bookName, Author author) {
        Book book = new Book(bookName,author);
        this.simpleDataHelper.addBook(book);
        return book;
    }

    @Override
    public Author addAuthor(String authorName, int year) {
        Author author = new Author(authorName,year);
        this.simpleDataHelper.addAuthors(author);
        return author;
    }
}
