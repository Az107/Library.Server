package dev.albruiz.libraryserver.Model;

import java.util.ArrayList;
import java.util.List;

public class User  {

    List<Book> books = new ArrayList<>();

    String name;
    public Book addBook(Book book) {
        books.add((Book) book);
        return book;
    }

    public Book removeBook(Book book) {
        books.remove(book);
        return  book;
    }


    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return this.books;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBooks(List<Book> books) {
        books.forEach((ibook) -> this.books.add((Book) ibook));
    }


    public User(String name){
        this.name = name;
    }
    public User(){

    }

}
