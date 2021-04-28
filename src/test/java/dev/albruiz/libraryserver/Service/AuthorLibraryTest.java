package dev.albruiz.libraryserver.Service;

import dev.albruiz.libraryserver.Model.Author;
import dev.albruiz.libraryserver.dao.IDataHelper;
import dev.albruiz.libraryserver.dao.MongoHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class AuthorLibraryTest {

    @MockBean
    IDataHelper mongoHelperMock;



    AuthorLibraryTest(){

    }

    @BeforeAll
    void configMock() {
        mongoHelperMock = Mockito.mock(MongoHelper.class);
        Mockito.when(mongoHelperMock.findAuthor(Mockito.anyString())).thenReturn(new Author("Test",2011));
    }

    @Test
    void getAuthors() {

    }

    @Test
    void findAuthor() {
    }

    @Test
    void addAuthor() {
    }
}