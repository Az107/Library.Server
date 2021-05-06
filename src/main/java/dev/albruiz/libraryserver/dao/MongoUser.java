package dev.albruiz.libraryserver.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import dev.albruiz.libraryserver.Model.Book;
import dev.albruiz.libraryserver.Model.User;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.push;

@Repository
@Profile("mongo")
public class MongoUser extends MongoHelper<User> {


    public MongoUser(MongoDatabase database) {
        this.collection = database.getCollection("Users", User.class);
    }

    public void addBooktoUser(String userName,Book book){
        UpdateResult updateResult = collection.updateOne(eq("name",userName),push("books",book));

    }

}
