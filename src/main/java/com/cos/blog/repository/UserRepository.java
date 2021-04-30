package com.cos.blog.repository;

import com.cos.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
//User table을 관리하는 Repository usertable의 프라이머리 키는 Integer

//자동으로 bean등록이 도밈./ @Repository 생략가능.
//DAO
public interface UserRepository extends JpaRepository<User, Integer>{
    Optional<User> findByUsername(String username);
    // SELECT * FROM user WHERE username = 1?;

}










// JPA NAMING 전략
//User findByUsernameAndPassword(String username, String password);


    /*@Query(value = "SELECT * FROM user WHERE username = ?1 AND password = ?2", nativeQuery = true)
    User login(String username, String password);*/