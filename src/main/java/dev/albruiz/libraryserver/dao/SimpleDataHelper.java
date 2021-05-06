package dev.albruiz.libraryserver.dao;

import dev.albruiz.libraryserver.Model.LibraryObject;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


public class SimpleDataHelper<T extends LibraryObject> implements IDataHelper<T>{

    List<T> data = new ArrayList<>();

    @Override
    public T find(String Name) {
        for(T item : data){
            if(item.getName().equals(Name)) return item;
        }
        return null;
    }

    @Override
    public List<T> getAll() {
        return data;
    }


    @Override
    public void add(T item) {
        data.add(((T)item));
    }


}
