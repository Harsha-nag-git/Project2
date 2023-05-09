package com.SpringBoot.project2.Repository;

import com.SpringBoot.project2.Entity.UserFollow;
import com.SpringBoot.project2.Entity.UserPosts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserFollowRepository extends JpaRepository<UserFollow,Long> {

    @Query(
            value = "select * from user_follow  where follower_id = ?1",
            nativeQuery = true
    )
    public List<UserFollow> findByUserIdToGetFollower(Long id);
}
