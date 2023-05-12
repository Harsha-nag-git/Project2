package com.SpringBoot.project2.Repository;

import com.SpringBoot.project2.Entity.Posts;
import liquibase.pro.packaged.I;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Posts,Integer> {
    @Query(
            value = "select * from posts  where user_id = ?1",
            nativeQuery = true
    )
    public List<Posts> findByUserIdToGetPosts(Integer id);
}
