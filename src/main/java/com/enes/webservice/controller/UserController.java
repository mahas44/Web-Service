package com.enes.webservice.controller;

import com.enes.webservice.model.AppUser;
import com.enes.webservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController{

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
    public AppUser addUser(@RequestBody AppUser newAppUser){
        if (userIsExist(newAppUser.getUsername())){
            return null;
        } else {
            AppUser appUser = new AppUser(newAppUser.getUsername(), newAppUser.getPassword(), newAppUser.getEmail());
            userRepository.insert(appUser);
            return appUser;
        }
    }

    private boolean userIsExist(String username){
        if (anyUsersAreExistInCollection()){
            Optional<AppUser> user  = userRepository.findByUsername(username);
            return user.isPresent();
        } else {
            return false;
        }
    }

    private boolean anyUsersAreExistInCollection(){
        int i  = userRepository.findAll().size();
        return i > 0;
    }
}
