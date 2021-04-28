package dev.albruiz.libraryserver.Service;

import dev.albruiz.libraryserver.Model.Author;
import dev.albruiz.libraryserver.dao.SimpleDataHelper;
import dev.albruiz.libraryserver.dao.IDataHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorLibrary implements IAuthorLibrary{

    IDataHelper dataHelper;

    @Autowired
    AuthorLibrary(IDataHelper SimpleDataHelper){
        dataHelper = SimpleDataHelper;
    }

    @Override
    public List<Author> getAuthors() {
        return dataHelper.getAuthors();
    }

    @Override
    public Author findAuthor(String name) {
            return dataHelper.findAuthor(name);
    }

    @Override
    public Author addAuthor(String authorName, int year) {
        Author author = new Author(authorName,year);
        dataHelper.addAuthors(author);
        return author;
    }
}
