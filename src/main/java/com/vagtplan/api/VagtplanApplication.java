package com.vagtplan.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class VagtplanApplication {

    public static void main(String[] args) {

        SpringApplication.run(VagtplanApplication.class, args);


    }

}

@Controller
class controller {
    @RequestMapping("/")
    public String index() {
        return "index.html";
    }
}
