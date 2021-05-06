package dev.albruiz.libraryserver.dao;


import dev.albruiz.libraryserver.Model.Book;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("inMemory")
public class SimpleBook extends SimpleDataHelper<Book>  implements IDataHelper<Book> {
}
