package com.cos.blog.repository;

import com.cos.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
//User table을 관리하는 Repository usertable의 프라이머리 키는 Integer

//자동으로 bean등록이 도밈./ @Repository 생략가능.
//DAO
public interface UserRepository extends JpaRepository<User, Integer>{

}
