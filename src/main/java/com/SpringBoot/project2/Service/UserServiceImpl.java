package com.SpringBoot.project2.Service;

import com.SpringBoot.project2.Dto.UserDto;
import com.SpringBoot.project2.Dto.UserFollowDto;
import com.SpringBoot.project2.Dto.UserPostDto;
import com.SpringBoot.project2.Entity.User;
import com.SpringBoot.project2.Entity.UserFollow;
import com.SpringBoot.project2.Entity.UserPosts;
import com.SpringBoot.project2.Repository.UserFollowRepository;
import com.SpringBoot.project2.Repository.UserPostRepository;
import com.SpringBoot.project2.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserPostRepository userPostRepository;
    @Autowired
    private UserFollowRepository userFollowRepository;

    public User saveUsers(User user){return userRepository.save(user);}

    //--------------getUsersList--------------------------
    public List<UserDto> getUsersList(){
        return userRepository.findAll()
                .stream()
                .map(this::userDataList)
                .collect(Collectors.toList()); }
    public UserDto userDataList(User user){
        UserDto userDto =new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());

        return userDto;
    }
    //---------------------------------------------------
    @Override
    public User loginByEmailAndPassword(String email, String password) {
        return userRepository.findUserByEmailAndPassword(email,password);
    }
    @Override
    public UserPosts saveUserPosts(Long id, UserPosts userPosts) {
        userPosts.setUser(userRepository.findById(id).get());
        return userPostRepository.save(userPosts);}

    //-----------getUserPosts---------------------
    @Override
    public List<UserPostDto> getUserPostsByUserId(Long id){
        return userPostRepository.findByUserIdToGetPosts(id)
                .stream()
                .map(this::getUserPosts)
                .collect(Collectors.toList());
    }
    private UserPostDto getUserPosts(UserPosts userPosts){
        UserPostDto userPostDto =new UserPostDto();
        userPostDto.setPostId(userPosts.getPostId());
        userPostDto.setPost(userPosts.getPost());
        userPostDto.setUserId(userPosts.getUser().getId());

        return userPostDto;
    }
    //--------------------------------------------------------
    @Override
    public UserFollow saveUserFollowData(Long id, UserFollow userFollow){
        userFollow.setUser(userRepository.findById(id).get());
        return userFollowRepository.save(userFollow);
    }
    //------------------**-------------------------------
    @Override
    public List<UserFollowDto> getUserFollowByUserId(Long id) {
         return userFollowRepository.findByUserIdToGetFollower(id)
                .stream()
                .map(this::getUserFollow)
                .collect(Collectors.toList());

    }
    private UserFollowDto getUserFollow(UserFollow userFollow){
        UserFollowDto userFollowDto =  new UserFollowDto();
        userFollowDto.setUfId(userFollow.getUfId());
        userFollowDto.setFollowingId(userFollow.getFollowingId());
        userFollowDto.setFollowerId(userFollow.getUser().getId());

        return userFollowDto;
    }
    //--------------------------------------------------------------
    public UserPosts getFollowersData(Long followerId,Long followingId){
        UserPosts userPosts = userPostRepository.findById(followerId).get();
        return userPosts;
    }

}