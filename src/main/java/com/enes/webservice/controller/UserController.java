package com.enes.webservice.controller;

import com.enes.webservice.IResponsableObject;
import com.enes.webservice.model.AppUser;
import com.enes.webservice.model.CustomErrorType;
import com.enes.webservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController{
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/", produces = "application/json; charset=utf-8")
    public String getHealthCheck(){
        return "{ \"isWorking\" : true }";
    }

    @GetMapping("/users")
    public List<AppUser> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public Optional<AppUser> getUser(@PathVariable String id){
        return userRepository.findById(id);
    }

    @PostMapping("/register")
    public IResponsableObject addUser(@RequestBody AppUser newAppUser){
        if (userRepository.existsAppUserByUsername(newAppUser.getUsername())){
            return new CustomErrorType(false,"This username `" + newAppUser.getUsername() + "` already exist.");
        } else if (userRepository.existsAppUserByEmail(newAppUser.getEmail())){
            return new CustomErrorType(false,"This email `" + newAppUser.getEmail() + "` already exist.");
        }
        else {
            newAppUser.setPassword(bCryptPasswordEncoder.encode(newAppUser.getPassword()));
            userRepository.insert(newAppUser);
            return newAppUser;
        }
    }

}
