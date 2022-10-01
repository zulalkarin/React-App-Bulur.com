package com.project.webApp.controller;

import com.project.webApp.entity.User;
import com.project.webApp.requests.UserUpdateRequest;
import com.project.webApp.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService= userService;
    }

    //list all users
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    //add new user
    @PostMapping
    public User createOneUser(@RequestBody User newUser){
        return userService.saveOneUser(newUser);
    }

    //show the user with given id
    @GetMapping("/{userId}")
    public User getOneUser(@PathVariable Long userId){
        return userService.getOneUser(userId);

    }

    //update one user
    @PutMapping("/{userId}")
    public User UpdateOneUser(@PathVariable Long userId, @RequestBody UserUpdateRequest newUserUpdateRequest){
        return userService.updateOneUser(userId, newUserUpdateRequest);

    }

    //delete the user
    @DeleteMapping ("/{userId}")
    public void deleteUser(@PathVariable Long userId){
        userService.deleteById(userId);
    }

}
