package dev.albruiz.libraryserver.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController implements IMainController {



    @Override
    @GetMapping("/")
    public String root() {
        return "Server Working ✅";
    }


}
