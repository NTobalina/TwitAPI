package com.nick.twitapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private final Logger log = LoggerFactory.getLogger(MainController.class);

    @GetMapping("/holo")
    public String holo() {
        log.info("GET: /holo");
        return "Holo holo holooo!";
    }

}
