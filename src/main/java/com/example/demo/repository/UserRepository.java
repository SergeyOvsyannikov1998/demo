package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
        @Query(value = "select distinct user from User user join fetch user.roles roles where user.login=:name")
    User getUserByFirstNam(@Param("name") String name);
}

