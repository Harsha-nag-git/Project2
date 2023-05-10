package com.SpringBoot.project2.Service;

import com.SpringBoot.project2.Dto.UserDto;
import com.SpringBoot.project2.Dto.FollowDto;
import com.SpringBoot.project2.Dto.PostDto;
import com.SpringBoot.project2.Entity.Follow;
import com.SpringBoot.project2.Entity.Posts;
import com.SpringBoot.project2.Entity.User;
import com.SpringBoot.project2.Repository.FollowRepository;
import com.SpringBoot.project2.Repository.PostRepository;
import com.SpringBoot.project2.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private FollowRepository followRepository;

    public User saveUser(com.SpringBoot.project2.Entity.User user){
        user.setPassword(String.valueOf(user.getPassword().hashCode()));
        return userRepository.save(user);}

    //--------------getUsersList--------------------------
    public List<UserDto> getUsers(){
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
    public Posts savePosts(Long id, Posts posts) {
        posts.setUser(userRepository.findById(id).get());
        return postRepository.save(posts);}

    //-----------getUserPosts---------------------
    @Override
    public List<PostDto> getPostsByUserId(Long id){
        return postRepository.findByUserIdToGetPosts(id)
                .stream()
                .map(this::getUserPosts)
                .collect(Collectors.toList());
    }
    private PostDto getUserPosts(Posts posts){
        PostDto postDto =new PostDto();
        postDto.setPostId(posts.getPostId());
        postDto.setPost(posts.getPost());
        postDto.setUserId(posts.getUser().getId());

        return postDto;
    }
    //--------------------------------------------------------
    @Override
    public Follow saveUserFollowData(Long id, Follow follow){
        follow.setUser(userRepository.findById(id).get());
        return followRepository.save(follow);
    }
    //------------------**-------------------------------
    @Override
    public List<FollowDto> getUserFollowByUserId(Long id) {
         return followRepository.findByUserIdToGetFollower(id)
                .stream()
                .map(this::getUserFollow)
                .collect(Collectors.toList());

    }
    private FollowDto getUserFollow(Follow follow){
        FollowDto followDto =  new FollowDto();
        followDto.setUfId(follow.getUfId());
        followDto.setFollowingId(follow.getFollowingId());
        followDto.setFollowerId(follow.getUser().getId());

        return followDto;
    }
    //--------------------------------------------------------------
    public Posts getFollowersData(Long followerId, Long followingId){
        Posts posts = postRepository.findById(followerId).get();
        return posts;
    }

}