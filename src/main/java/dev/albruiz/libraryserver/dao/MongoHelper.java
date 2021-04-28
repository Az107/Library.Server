package dev.albruiz.libraryserver.dao;


import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import com.mongodb.client.result.UpdateResult;
import dev.albruiz.libraryserver.Model.Author;
import dev.albruiz.libraryserver.Model.Book;
import dev.albruiz.libraryserver.Model.User;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.push;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;


@Service
public class MongoHelper implements IDataHelper {
    private final MongoDatabase database;
    private final MongoCollection<Author> authorsCollection;
    private final MongoCollection<Book> bookCollection;
    private final MongoCollection<User> userCollection;

    public Book findBook(String Name){
        Book book =  bookCollection.find(eq("name",Name)).first();
        return book;
    }

    public List<Book> getBooks(){
        List<Book> books = new ArrayList<>();
        FindIterable<Book> bookIterable =  bookCollection.find();
        bookIterable.forEach((books::add));
        return  books;
    }

    public void addBook(Book book){
        bookCollection.insertOne(book);
    }

    public List<Author> getAuthors(){
        List<Author> authors = new ArrayList<>();
        FindIterable<Author> authorsIterable =  authorsCollection.find();
        authorsIterable.forEach((authors::add));
        return  authors;
    }

    public Author findAuthor(String Name){
        return authorsCollection.find(eq("name",Name)).first();
    }

    public void addAuthors(Author author){
        authorsCollection.insertOne(author);
    }

    public List<User> getUsers(){
        List<User> users = new ArrayList<>();
        FindIterable<User> usersIterable =  userCollection.find();
        usersIterable.forEach((users::add));
        return  users;
    }

    public User findUser(String Name){
        return userCollection.find(eq("name",Name)).first();
    }

    public void addUser(User user){
        userCollection.insertOne(user);
    }

    public void addBooktoUser(String userName,Book book){
        UpdateResult updateResult = userCollection.updateOne(eq("name",userName),push("books",book));

    }

    MongoHelper(){
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));

        MongoClient client = MongoClients.create("mongodb://servidor:27017");
        database =  client.getDatabase("Library").withCodecRegistry(pojoCodecRegistry);
        authorsCollection = database.getCollection("Authors", Author.class);
        bookCollection = database.getCollection("Books", Book.class);
        userCollection = database.getCollection("Users", User.class);


    }

}
