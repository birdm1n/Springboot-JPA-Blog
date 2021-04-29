package com.cos.blog.service;

import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.reflect.annotation.ExceptionProxy;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Integer 회원가입(User user) {
        try {
            userRepository.save(user);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("" + e.getMessage());

        }
        return -1;
    }




    /*@Transactional(readOnly = true) // select 할떄 트랜잭션 시작 , 서비스 종료시에[ 트랜잭션 종료 정합성!
    public User 로그인(User user){
        return userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());
    }*/
}
