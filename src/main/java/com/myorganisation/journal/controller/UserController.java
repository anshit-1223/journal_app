package com.myorganisation.journal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public String getAllUser(){
        return "Users List";
    }

    @GetMapping("/$id")
    public int getUserById(int id){
        return id;
    }
}
