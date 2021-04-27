package dev.albruiz.libraryserver.Service;

import dev.albruiz.libraryserver.Model.Author;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class AuthorLibraryTest {

    @MockBean
    AuthorLibrary AuthorLibraryMock;

    AuthorLibraryTest(){
        AuthorLibraryMock = Mockito.mock(AuthorLibrary.class);
        AuthorLibraryMock.authors.add(new Author("test1",2011));
    }

    @Test
    void getAuthors() {
        Author[] authors = new Author[]{new Author("test1",2011)};
        AuthorLibraryMock.getAuthors();
        Assertions.assertArrayEquals(AuthorLibraryMock.getAuthors(),authors);

    }

    @Test
    void findAuthor() {
    }

    @Test
    void addAuthor() {
    }
}