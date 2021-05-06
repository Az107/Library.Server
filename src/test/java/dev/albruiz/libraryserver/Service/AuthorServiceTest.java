package dev.albruiz.libraryserver.Service;

import dev.albruiz.libraryserver.Model.Author;
import dev.albruiz.libraryserver.Model.LibraryObject;
import dev.albruiz.libraryserver.dao.IDataHelper;
import org.junit.jupiter.api.Assertions;
import static org.assertj.core.api.Assertions.*;
import static org.hamcrest.Matchers.samePropertyValuesAs;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.activation.DataHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class AuthorServiceTest {

    @MockBean
    IDataHelper<Author> dataHelper;

    @Autowired
    AuthorService authorService;


    @Test
    void getAuthors() {
        // GIVEN
        Author author1 = new Author("Test", 2011);
        Author author2 = new Author("Test2", 2011);

        Mockito.when(dataHelper.getAll()).thenReturn(Arrays.asList(author1, author2));

        // WHEN
        List<Author> authors = authorService.getAuthors();

        // THEN
        assertThat(authors).contains(author1);

        // CLEAN
        Mockito.reset(dataHelper);
    }

    @Test
    void getAuthorsNull() {
        // GIVEN

        Mockito.when(dataHelper.getAll()).thenReturn(null);

        // WHEN
        List<Author> authors = authorService.getAuthors();

        // THEN
        assertThat(authors).isNull();

        // CLEAN
        Mockito.reset(dataHelper);
    }

    @Test
    void getAuthorsException() {
        // GIVEN

        Mockito.when(dataHelper.getAll()).thenThrow(new Exception());

        // WHEN
        List<Author> authors = authorService.getAuthors();

        // THEN
        assertThat(authors).isNull();

        // CLEAN
        Mockito.reset(dataHelper);
    }

    @Test
    void findAuthor() {
        // GIVEN
        Author author = new Author("Test", 2011);
        Mockito.when(dataHelper.find(Mockito.anyString())).thenReturn(author);

        // WHEN
        Author authorFound = authorService.findAuthor(author.getName());


        // THEN
        assertThat(authorFound).isEqualTo(author);

        // CLEAN
        Mockito.reset(dataHelper);
    }

    @Test
    void findAuthorNull() {
        // GIVEN
        Author author = new Author("Test", 2011);
        Mockito.when(dataHelper.find(Mockito.anyString())).thenReturn(null);

        // WHEN
        Author authorFound = authorService.findAuthor(author.getName());


        // THEN
        assertThat(authorFound).isNull();

        // CLEAN
        Mockito.reset(dataHelper);
    }

    @Test
    void findAuthorException() {
        // GIVEN
        Author author = new Author("Test", 2011);
        Mockito.when(dataHelper.find(Mockito.anyString())).thenThrow(new Exception());

        // WHEN
        Author authorFound = authorService.findAuthor(author.getName());


        // THEN
        assertThat(authorFound).isNull();


        // CLEAN
        Mockito.reset(dataHelper);
    }


    @Test
    void addAuthor(){
        // GIVEN
        Author author = new Author("Test", 2011);

        // WHEN
        Author authorFound = authorService.addAuthor(author.getName(),author.getYear());


        // THEN
        assertThat(authorFound.getName()).isEqualTo(author.getName());
        assertThat(authorFound.getYear()).isEqualTo(author.getYear());


        // CLEAN
        Mockito.reset(dataHelper);
    }

    @Test
    void addAuthorNull(){
        // GIVEN
        Author author = new Author("Test", 2011);

        // WHEN
        Author authorFound = authorService.addAuthor(null,0);


        // THEN
        assertThat(authorFound).isNull();


        // CLEAN
        Mockito.reset(dataHelper);
    }

    @Test
    void addAuthorException(){
        // GIVEN
        Author author = new Author("Test", 2011);
        Mockito.doThrow(new Exception()).when(dataHelper).add(Mockito.any(Author.class));
        // WHEN
        Author authorFound = authorService.addAuthor(author.getName(),author.getYear());


        // THEN
        assertThat(authorFound).isNull();


        // CLEAN
        Mockito.reset(dataHelper);
    }

}