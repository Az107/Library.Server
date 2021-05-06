package dev.albruiz.libraryserver.dao;

import com.mongodb.client.result.UpdateResult;
import dev.albruiz.libraryserver.Model.Book;
import dev.albruiz.libraryserver.Model.User;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.push;

@Repository
@Profile("inMemory")
public class SimpleUser extends SimpleDataHelper<User>  implements IDataHelper<User> {

    public void addBooktoUser(User user, Book book){
        user.addBook(book);
    }
}
