package com.SpringBoot.project2.Service;

import com.SpringBoot.project2.Dto.UserDto;
import com.SpringBoot.project2.Dto.FollowDto;
import com.SpringBoot.project2.Dto.PostDto;
import com.SpringBoot.project2.Entity.Follow;
import com.SpringBoot.project2.Entity.Posts;
import com.SpringBoot.project2.Entity.User;

import java.util.List;

public interface Service {
    User saveUser(User user);

    List<UserDto> getUsers();
    User loginByEmailAndPassword(String email, String password);

    Posts savePosts(Long id, Posts posts);

    //-----------userPosts---------------------
    List<PostDto> getPostsByUserId(Long id);

    //--------------------------------------------------------
    Follow saveUserFollowData(Long id, Follow follow);

    List<FollowDto> getUserFollowByUserId(Long id);

}
