package com.myorganisation.journal.controller;
import com.myorganisation.journal.model.UserModel;
import com.myorganisation.journal.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @GetMapping
    public List getAllUsers(){
        return userService.getAll();
    }

    @PostMapping()
    public void createUser(@RequestBody UserModel user){
        userService.saveEntry(user);

    }
}
