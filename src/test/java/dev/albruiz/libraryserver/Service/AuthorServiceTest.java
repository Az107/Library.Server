package dev.albruiz.libraryserver.Service;

import dev.albruiz.libraryserver.Model.Author;
import dev.albruiz.libraryserver.dao.IDataHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.activation.DataHandler;
import java.util.ArrayList;
import java.util.Arrays;

@SpringBootTest
class AuthorServiceTest {

    IDataHelper<Author> dataHelper;

    AuthorService authorService;

    AuthorServiceTest(){
        dataHelper = Mockito.mock(IDataHelper.class);
        Author author1 = new Author("Test",2011);
        Author author2 = new Author("Test2",2011);

        Mockito.when(dataHelper.getAll()).thenReturn(Arrays.asList(author1, author2));
        Mockito.when(dataHelper.find(Mockito.anyString())).thenReturn(author1);
        authorService = new AuthorService(dataHelper);
        System.out.println("config mock");
    }

    @Test
    void getAuthors() {
        int c = authorService.getAuthors().size();
        Assertions.assertEquals(c,2);
    }

    @Test
    void findAuthor() {
        Author author = authorService.findAuthor("test");
        Assertions.assertEquals(author.getName(),new Author("Test",2011).getName());
        Assertions.assertEquals(author.getYear(),new Author("Test",2011).getYear());

    }


}