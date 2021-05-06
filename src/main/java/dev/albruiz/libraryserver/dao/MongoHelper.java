package dev.albruiz.libraryserver.dao;


import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import com.mongodb.client.result.UpdateResult;
import dev.albruiz.libraryserver.Model.Author;
import dev.albruiz.libraryserver.Model.Book;
import dev.albruiz.libraryserver.Model.LibraryObject;
import dev.albruiz.libraryserver.Model.User;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.push;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;



public class MongoHelper<T extends LibraryObject> implements IDataHelper<T> {

    protected MongoCollection<T> collection;

    @Override
    public T find(String Name) {
        T item =  collection.find(eq("name",Name)).first();
        return item;
    }

    @Override
    public List<T> getAll() {
        List<T> items = new ArrayList<>();
        FindIterable<T> tIterable =  collection.find();
        tIterable.forEach((items::add));
        return  items;
    }

    @Override
    public void add(T o) {
        collection.insertOne((T)o);
    }
}
