package dev.albruiz.libraryserver.Service;

import dev.albruiz.libraryserver.Model.Book;
import dev.albruiz.libraryserver.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserLibrary implements  IUserLibrary {



    List<User> users = new ArrayList<>();
    IBookLibrary bookLibrary;

    @Autowired
    UserLibrary(IBookLibrary bookLibrary){this.bookLibrary = bookLibrary;}

    @Override
    public User[] getUsers() {
        return this.users.toArray(new User[this.users.size()]);
    }

    @Override
    public User findUser(String name) {
        for (User user: users) {
            if (user.getName().equals(name)) return user;
        }
        return null;
    }

    @Override
    public User rentBook(String userName,String bookName) {
        User user = findUser(userName);
        Book book = bookLibrary.findBook(bookName);
        user.addBook(book);
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
        users.add(user);
        return  user;
    }
}
