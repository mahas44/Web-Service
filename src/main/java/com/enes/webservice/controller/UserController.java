package com.enes.webservice.controller;

import com.enes.webservice.model.User;
import com.enes.webservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getUsers(){
        List<User> userList = userRepository.findAll();
        return userList;
    }

    @GetMapping("/user/{id}")
    public Optional<User> getUser(@PathVariable String id){
        Optional<User> user = userRepository.findById(id);
        return  user;
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User newUser){
        String id = UUID.randomUUID().toString();
        User user = new User(id, newUser.getName(),newUser.getSurname(), newUser.getEmail());
        if (userIsExist(newUser.getEmail())){
            return null;
        } else {
            userRepository.insert(user);
            return user;
        }
    }

    @GetMapping("/searchByEmail/{email}")
    public Optional<User> getUserByEmail(@PathVariable String email){
        Optional<User> user =  userRepository.findByEmail(email);
        return user;
    }

    private boolean userIsExist(String email){
        if (anyUsersAreExistInCollection()){
            Optional<User> user  = userRepository.findByEmail(email);
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
