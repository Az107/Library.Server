package dev.albruiz.libraryserver.Service;

import dev.albruiz.libraryserver.Model.Author;
import dev.albruiz.libraryserver.dao.IDataHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService implements IAuthorService {

    IDataHelper<Author> dataHelper;

    @Autowired
    AuthorService(@Qualifier("simpleDataHelper") IDataHelper<Author> dataHelper){
        this.dataHelper = dataHelper;
    }

    @Override
    public List<Author> getAuthors() {
        return dataHelper.getAll();
    }

    @Override
    public Author findAuthor(String name) {
            return dataHelper.find(name);
    }

    @Override
    public Author addAuthor(String authorName, int year) {
        Author author = new Author(authorName,year);
        dataHelper.add(author);
        return author;
    }
}
