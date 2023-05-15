package com.SpringBoot.project2.Repository;

import com.SpringBoot.project2.Entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowRepository extends JpaRepository<Follow,Integer> {

    @Query(
            value = "select * from follow  where user_id = ?1",
            nativeQuery = true
    )
    public List<Follow> findByUserIdToGetFollower(Integer id);
}
