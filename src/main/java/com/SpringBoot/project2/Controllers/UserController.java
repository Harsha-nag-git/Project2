package com.SpringBoot.project2.Controllers;

import com.SpringBoot.project2.Dto.UserDto;
import com.SpringBoot.project2.Dto.UserFollowDto;
import com.SpringBoot.project2.Dto.UserPostDto;
import com.SpringBoot.project2.Entity.User;
import com.SpringBoot.project2.Entity.UserFollow;
import com.SpringBoot.project2.Entity.UserPosts;
import com.SpringBoot.project2.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/user")
    public String saveUsers(@RequestBody User user){
        User user1 = userService.saveUsers(user); return "Successfully Uploaded";}
    @GetMapping("/users")
    public List<UserDto> getUsersList(){ return userService.getUsersList(); }
    @GetMapping("/user/{email}/{password}")
    public User loginByEmailAndPassword(@PathVariable("email") String email,
                                        @PathVariable("password") String password) {
        return userService.loginByEmailAndPassword(email, password);
    }
    @PostMapping("/user/post/{userId}")
    public String saveUserPosts(@PathVariable("userId")Long id,
                                   @RequestBody UserPosts userPosts){
        UserPosts posts = userService.saveUserPosts(id,userPosts);
        return "Successfully Posted";
    }
    @GetMapping("/user/posts/{user_id}")
    public List<UserPostDto> getUserPostsByUserId(@PathVariable("user_id") Long id){
        return  userService.getUserPostsByUserId(id);
    }
    @PostMapping("/user/follow/{follower_id}")
    public String saveUserFollowData(@PathVariable("follower_id") Long id,
                                         @RequestBody UserFollow userFollow){
        UserFollow Follow = userService.saveUserFollowData(id,userFollow);
        return "Successfully Followed";
    }
    @GetMapping("/user/follow/{follower_id}")
    public List<UserFollowDto> getUserFollowByUserId(@PathVariable("follower_id") Long id){
        return  userService.getUserFollowByUserId(id);
    }


}
