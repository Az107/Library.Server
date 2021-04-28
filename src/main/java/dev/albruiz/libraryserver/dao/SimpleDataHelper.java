package dev.albruiz.libraryserver.dao;

import dev.albruiz.libraryserver.Model.Author;
import dev.albruiz.libraryserver.Model.Book;
import dev.albruiz.libraryserver.Model.User;

import java.util.ArrayList;
import java.util.List;

public class SimpleDataHelper implements IDataHelper{

    List<Book> books = new ArrayList<>();
    List<Author> authors = new ArrayList<>();
    List<User> users = new ArrayList<>();

    @Override
    public Book findBook(String Name) {
        for (Book b:
             books) {
            if (b.getName().equals(Name)) return b;
        }
        return  null;
    }

    @Override
    public List<Book> getBooks() {
        return books;
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public List<Author> getAuthors() {
        return authors;
    }

    @Override
    public Author findAuthor(String Name) {
        for (Author a:
                authors) {
            if (a.getName().equals(Name)) return a;
        }
        return  null;
    }

    @Override
    public void addAuthors(Author author) {
        authors.add(author);
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public User findUser(String Name) {
        for (User u:
                users) {
            if (u.getName().equals(Name)) return u;
        }
        return  null;
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void addBooktoUser(String userName, Book book) {
        this.findUser(userName).addBook(book);
    }
}
