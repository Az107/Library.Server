package dev.albruiz.libraryserver.Model;

public class Author  {

    String name;
    int year;

    public Author(String name, int year){
        this.name = name;
        this.year = year;
    }

    public Author(){ }

    public String getName() {
        return this.name;
    }

    public int getYear() {
        return year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
