package dev.albruiz.libraryserver.Service;

import dev.albruiz.libraryserver.Model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Library implements  ILibrary{

    List<Book> books = new ArrayList<>();
    List<Author> authors = new ArrayList<>();
    List<User> users = new ArrayList<>();

    @Override
    public Book[] getBooks() {
        return this.books.toArray(new Book[this.books.size()]);
    }

    @Override
    public Author[] getAuthors() {
        return this.authors.toArray(new Author[this.authors.size()]);
    }

    @Override
    public User[] getUsers() {
        return this.users.toArray(new User[this.users.size()]);
    }

    @Override
    public User findUser(String name) {
        for (User user: users) {
            if (user.getName().equals(name)) return user;
        }
        return null;
    }

    @Override
    public Book findBook(String name) {
        for (Book book: books) {
            if (book.getName().equals(name)) return book;
        }
        return null;
    }

    @Override
    public Author findAuthor(String name) {
        for (Author author: authors) {
            if (author.getName().equals(name)) return author;
        }
        return null;
    }

    @Override
    public User rentBook(User user, Book book) {
        user.addBook(book);
        return user;
    }

    @Override
    public User returnBook(User user, Book book) {
        return null;
    }

    @Override
    public User addUser(String userName) {
        User user = new User(userName);
        users.add(user);
        return  user;
    }

    @Override
    public Book addBook(String bookName, Author author) {
        Book book = new Book(bookName,author);
        books.add(book);
        return  book;
    }

    @Override
    public Author addAuthor(String authorName,int year) {
        Author author = new Author(authorName,year);
        authors.add(author);
        return author;
    }
}
