package com.myorganisation.journal.service;

import com.myorganisation.journal.model.UserModel;
import com.myorganisation.journal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveEntry(UserModel user){
        userRepository.save(user);
    }

    public List<UserModel> getAll(){
        return userRepository.findAll();
    }
}
