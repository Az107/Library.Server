package dev.albruiz.libraryserver.Service;

import dev.albruiz.libraryserver.Model.Author;
import dev.albruiz.libraryserver.Service.Exceptions.NotFoundException;
import dev.albruiz.libraryserver.dao.IDataHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService implements IAuthorService {

    IDataHelper<Author> dataHelper;

    @Autowired
    AuthorService(IDataHelper<Author> dataHelper){
        this.dataHelper = dataHelper;
    }

    @Override
    public List<Author> getAuthors() {

        return dataHelper.getAll();
    }

    @Override
    public Author findAuthor(String name) throws NotFoundException {
        Author author = dataHelper.find(name);
        if (author == null) throw new NotFoundException();
        return author;
    }

    @Override
    public void addAuthor(String authorName, int year) {
        Author author = new Author(authorName, year);
        dataHelper.add(author);
    }
}
