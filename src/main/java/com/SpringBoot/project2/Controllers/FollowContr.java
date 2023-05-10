package com.SpringBoot.project2.Controllers;

import com.SpringBoot.project2.Dto.FollowDto;
import com.SpringBoot.project2.Entity.Follow;
import com.SpringBoot.project2.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FollowContr {
    @Autowired
    private Service service;
    @PostMapping("/user/follow/{follower_id}")
    public String saveUserFollowData(@PathVariable("follower_id") Long id,
                                     @RequestBody Follow follow){
        Follow follow1 = service.saveUserFollowData(id, follow);
        return "Successfully Followed";
    }
    @GetMapping("/user/follow/{follower_id}")
    public List<FollowDto> getUserFollowByUserId(@PathVariable("follower_id") Long id) {
        return service.getUserFollowByUserId(id);
    }
}
