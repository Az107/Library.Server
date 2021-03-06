package dev.albruiz.libraryserver.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import dev.albruiz.libraryserver.Model.Author;
import dev.albruiz.libraryserver.Model.Book;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("mongo")
public class MongoAuthor extends MongoHelper<Author> {

    public MongoAuthor(MongoDatabase database) {
        this.collection = database.getCollection("Authors", Author.class);
    }

}
