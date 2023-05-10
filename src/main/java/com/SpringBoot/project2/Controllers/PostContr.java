package com.SpringBoot.project2.Controllers;

import com.SpringBoot.project2.Dto.PostDto;
import com.SpringBoot.project2.Entity.Posts;
import com.SpringBoot.project2.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostContr {
    @Autowired
    private Service service;

    @PostMapping("/user/post/{userId}")
    public String savePosts(@PathVariable("userId")Long id,
                                @RequestBody Posts userPosts){
        Posts posts = service.savePosts(id,userPosts);
        return "Successfully Posted";
    }
    @GetMapping("/user/posts/{user_id}")
    public List<PostDto> getUserPostsByUserId(@PathVariable("user_id") Long id){
        return  service.getPostsByUserId(id);
    }
}
