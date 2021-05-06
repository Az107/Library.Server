package dev.albruiz.libraryserver.dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.result.UpdateResult;
import dev.albruiz.libraryserver.Model.Author;
import dev.albruiz.libraryserver.Model.Book;
import dev.albruiz.libraryserver.Model.LibraryObject;
import dev.albruiz.libraryserver.Model.User;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.push;

public interface IDataHelper<T extends LibraryObject> {

    public T find(String Name);

    public List<T> getAll();

    public void add(T o);


}
