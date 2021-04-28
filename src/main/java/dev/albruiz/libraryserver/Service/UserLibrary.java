package dev.albruiz.libraryserver.Service;

import dev.albruiz.libraryserver.Model.Book;
import dev.albruiz.libraryserver.Model.User;
import dev.albruiz.libraryserver.dao.IDataHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserLibrary implements  IUserLibrary {



    IDataHelper dataHelper;
    IBookLibrary bookLibrary;

    @Autowired
    UserLibrary(IBookLibrary bookLibrary,IDataHelper SimpleDataHelper){
        this.bookLibrary = bookLibrary;
        this.dataHelper = SimpleDataHelper;
    }

    @Override
    public List<User> getUsers() {
        return dataHelper.getUsers();
    }

    @Override
    public User findUser(String name) {
        return dataHelper.findUser(name);
    }

    @Override
    public User rentBook(String userName,String bookName) {
        User user = findUser(userName);
        Book book = bookLibrary.findBook(bookName);
        dataHelper.addBooktoUser(userName,book);
        return user;
    }

    @Override
    public User returnBook(String  userName, String bookName) {
        User user = findUser(userName);
        Book book = bookLibrary.findBook(bookName);
        user.addBook(book);
        return user;
    }

    @Override
    public User addUser(String userName) {
        User user = new User(userName);
        dataHelper.addUser(user);
        return  user;
    }
}
