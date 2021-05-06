package dev.albruiz.libraryserver.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import dev.albruiz.libraryserver.Model.Book;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile("mongo")
public class MongoBook extends MongoHelper<Book> {


    public MongoBook(MongoDatabase database) {
        this.collection = database.getCollection("Books", Book.class);
    }

}
