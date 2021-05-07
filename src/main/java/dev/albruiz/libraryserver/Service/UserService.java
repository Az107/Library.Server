package dev.albruiz.libraryserver.Service;

import dev.albruiz.libraryserver.Model.Book;
import dev.albruiz.libraryserver.Model.User;
import dev.albruiz.libraryserver.Service.Exceptions.NotFoundException;
import dev.albruiz.libraryserver.dao.IDataHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements  IUserService {



    IDataHelper<User> dataHelper;
    IDataHelper<Book> dataHelperBook;


    @Autowired
    UserService(IDataHelper<User>  dataHelper, IDataHelper<Book> dataHelperBook){
        this.dataHelper = dataHelper;
        this.dataHelperBook = dataHelperBook;
    }

    @Override
    public List<User> getUsers() {
        return dataHelper.getAll();
    }

    @Override
    public User findUser(String name) throws NotFoundException {
        User user = dataHelper.find(name);
        if (user == null) throw new NotFoundException();
        return user;
    }

    @Override
    public User rentBook(String userName, String bookName) throws NotFoundException {
        User user = findUser(userName);
        Book book = dataHelperBook.find(bookName);
        user.addBook(book);
        //dataHelper.addBook(userName,book);
        return user;
    }

    @Override
    public User returnBook(String userName, String bookName) throws NotFoundException {
        User user = findUser(userName);
        Book book = dataHelperBook.find(bookName);
        user.addBook(book);
        return user;
    }

    @Override
    public void addUser(String userName) {
        User user = new User(userName);
        dataHelper.add(user);
    }
}
