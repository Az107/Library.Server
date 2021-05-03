package dev.albruiz.libraryserver.Service;

import dev.albruiz.libraryserver.Model.Book;
import dev.albruiz.libraryserver.Model.User;
import dev.albruiz.libraryserver.dao.IDataHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements  IUserService {



    IDataHelper<User> dataHelper;
    IBookService bookLibrary;

    @Autowired
    UserService(IBookService bookLibrary, @Qualifier("simpleDataHelper") IDataHelper<User> dataHelper){
        this.bookLibrary = bookLibrary;
        this.dataHelper = dataHelper;
    }

    @Override
    public List<User> getUsers() {
        return dataHelper.getAll();
    }

    @Override
    public User findUser(String name) {
        return dataHelper.find(name);
    }

    @Override
    public User rentBook(String userName,String bookName) {
        User user = findUser(userName);
        Book book = bookLibrary.findBook(bookName);
        //dataHelper.addBooktoUser(userName,book);
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
        dataHelper.add(user);
        return  user;
    }
}
