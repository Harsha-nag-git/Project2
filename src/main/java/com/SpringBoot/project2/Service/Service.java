package com.SpringBoot.project2.Service;

import com.SpringBoot.project2.Dto.FollowDto;
import com.SpringBoot.project2.Dto.PostDto;
import com.SpringBoot.project2.Dto.UserDto;
import com.SpringBoot.project2.Entity.Follow;
import com.SpringBoot.project2.Entity.Posts;
import com.SpringBoot.project2.Entity.User;

import java.util.List;

public interface Service {
    User saveUser(User user);

    List<UserDto> getUsers();
    User fetchByEmailAndPassword(String email, String password);

    Posts savePosts(Integer id, Posts userPosts);

    //-----------userPosts---------------------
    List<PostDto> getPostsByUserId(Integer id);

    //--------------------------------------------------------
    Follow saveUserFollowData(Integer id, Follow follow);

    List<FollowDto> getUserFollowByUserId(Integer id);


}
