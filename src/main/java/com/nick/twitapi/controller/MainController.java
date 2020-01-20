package com.nick.twitapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @RequestMapping("/holo")
    public String holo() {
        return "Holo holo holooo!";
    }

}
