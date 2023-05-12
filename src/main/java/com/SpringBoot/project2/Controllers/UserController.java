package com.SpringBoot.project2.Controllers;

import com.SpringBoot.project2.Dto.UserDto;
import com.SpringBoot.project2.Entity.User;
import com.SpringBoot.project2.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private Service service;
    @PostMapping("/user")
    public String saveUser(@RequestBody User user){ service.saveUser(user); return "Successfully Uploaded";}
    @GetMapping("/users")
    public List<UserDto> getUsers(){ return service.getUsers(); }
    @PostMapping("/user/email/{email}")
    public User fetchByEmailAndPassword(@PathVariable("email") String email,String password) {
        return service.fetchByEmailAndPassword(email,password);
    }

}
