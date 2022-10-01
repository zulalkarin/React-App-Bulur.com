package com.project.webApp.services;

import com.project.webApp.entity.User;
import com.project.webApp.repos.UserRepo;
import com.project.webApp.requests.UserUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepo userRepo;

    public UserService(UserRepo userRepo) { //alt + insert tuşu ile oluştur
        this.userRepo = userRepo;
    }


    public List<User> getAllUsers() {
        return userRepo.findAll();

    }

    public User saveOneUser(User newUser) {
        return userRepo.save(newUser);
    }

    public User getOneUser(Long userId) {
        //custom exception ekle
        return userRepo.findById(userId).orElse(null);
    }

    public User updateOneUser(Long userId, UserUpdateRequest newUserUpdateRequest) {
        Optional<User> user= userRepo.findById(userId);
        if(user.isPresent()){
            User foundUser = user.get();
            foundUser.setUserName(newUserUpdateRequest.getUserName());
            //foundUser.setId(newUser.getId());
            foundUser.setPassword(newUserUpdateRequest.getPassword());
            foundUser.setUserRole(newUserUpdateRequest.getUserRole());
            userRepo.save(foundUser);
            return foundUser;
        }
        else{
            return null;
        }
    }

    public void deleteById(Long userId) {
        Optional<User> user= userRepo.findById(userId);
        if(user.isPresent())
            userRepo.deleteById(userId);
    }
}
