package dev.albruiz.libraryserver.Service;

import dev.albruiz.libraryserver.Model.Author;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorLibrary implements IAuthorLibrary{

    List<Author> authors = new ArrayList<>();


    @Override
    public Author[] getAuthors() {
        return this.authors.toArray(new Author[this.authors.size()]);
    }

    @Override
    public Author findAuthor(String name) {
        for (Author author: authors) {
            if (author.getName().equals(name)) return author;
        }
        return null;
    }

    @Override
    public Author addAuthor(String authorName, int year) {
        Author author = new Author(authorName,year);
        authors.add(author);
        return author;
    }
}
