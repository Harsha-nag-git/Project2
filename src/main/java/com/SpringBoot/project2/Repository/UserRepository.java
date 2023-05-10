package com.SpringBoot.project2.Repository;

import com.SpringBoot.project2.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query(
            value = "select * from user u where u.email = ?1 and u.password = ?2",
            nativeQuery = true
    )
    public User findUserByEmailAndPassword(String email,String password);
}
