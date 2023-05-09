package com.SpringBoot.project2.Repository;

import com.SpringBoot.project2.Entity.UserPosts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPostRepository extends JpaRepository<UserPosts,Long> {
    @Query(
            value = "select * from user_posts  where user_id = ?1",
            nativeQuery = true
    )
    public List<UserPosts> findByUserIdToGetPosts(Long id);
}
