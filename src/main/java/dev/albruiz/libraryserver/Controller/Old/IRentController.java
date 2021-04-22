package dev.albruiz.libraryserver.Controller.Old;

import dev.albruiz.libraryserver.Model.User;

public interface IRentController {

    User RentBook(String bookName,String userName);
    User ReturnBook(String bookName,String UserName);

}
