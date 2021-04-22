package dev.albruiz.libraryserver.Controller;


import dev.albruiz.libraryserver.Service.ILibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController implements IMainController {


    @Autowired
    MainController(ILibrary library){
        this.library = library;
    }

    ILibrary library;

    @Override
    @GetMapping("/")
    public String root() {
        return "Server Working ✅";
    }


}
