package com.rianbow.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lailai on 2018/1/11.
 */
@RestController
@RequestMapping("/user")
public class userController {
    @GetMapping("/hi")
    public String hi(){
        return "i am lailai";
    }
}
