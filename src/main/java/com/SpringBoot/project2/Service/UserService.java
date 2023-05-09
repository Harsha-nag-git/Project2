package com.SpringBoot.project2.Service;

import com.SpringBoot.project2.Dto.UserDto;
import com.SpringBoot.project2.Dto.UserFollowDto;
import com.SpringBoot.project2.Dto.UserPostDto;
import com.SpringBoot.project2.Entity.User;
import com.SpringBoot.project2.Entity.UserFollow;
import com.SpringBoot.project2.Entity.UserPosts;

import java.util.List;

public interface UserService {
    User saveUsers(User user);

    List<UserDto> getUsersList();
    User loginByEmailAndPassword(String email, String password);

    UserPosts saveUserPosts(Long id, UserPosts userPosts);

    //-----------userPosts---------------------
    List<UserPostDto> getUserPostsByUserId(Long id);

    //--------------------------------------------------------
    UserFollow saveUserFollowData(Long id, UserFollow userFollow);

    List<UserFollowDto> getUserFollowByUserId(Long id);

    //--------------------------------------------------------------
}
