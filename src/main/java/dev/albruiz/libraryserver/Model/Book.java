package dev.albruiz.libraryserver.Model;


public class Book {
    String name;
    Author author;

    public Book(String name, Author author){
        this.name = name;
        this.author = (Author) author;
    }
    public  Book(){}

    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(Author author) {
        this.author = (Author) author;
    }

}
