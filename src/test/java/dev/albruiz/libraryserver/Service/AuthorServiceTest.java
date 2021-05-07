package dev.albruiz.libraryserver.Service;

import dev.albruiz.libraryserver.Model.Author;
import dev.albruiz.libraryserver.Service.Exceptions.NotFoundException;
import dev.albruiz.libraryserver.dao.IDataHelper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
    void findAuthor() throws NotFoundException {
        // GIVEN
        Author author = new Author("Test", 2011);
        Mockito.when(dataHelper.find(Mockito.anyString())).thenReturn(author);

        // THEN

        authorService.findAuthor(author.getName());

        // THEN

        // CLEAN
        Mockito.reset(dataHelper);
    }

    @Test()
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
        authorService.addAuthor(author.getName(), author.getYear());


        // THEN


        // CLEAN
        Mockito.reset(dataHelper);
    }

    @Test
    void addAuthorNull(){
        // GIVEN
        Author author = new Author("Test", 2011);

        // WHEN
        authorService.addAuthor(null, 0);


        // THEN



        // CLEAN
        Mockito.reset(dataHelper);
    }

    @Test
    void addAuthorException(){
        // GIVEN
        Author author = new Author("Test", 2011);
        Mockito.doThrow(new Exception()).when(dataHelper).add(Mockito.any(Author.class));
        // WHEN
        authorService.addAuthor(author.getName(), author.getYear());


        // THEN


        // CLEAN
        Mockito.reset(dataHelper);
    }

}