package com.cos.blog.service;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.reflect.annotation.ExceptionProxy;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder; //

    @Transactional
    public void 회원가입(User user) {
        try {
            String rawPassword = user.getPassword();
            String encPassword = encoder.encode(rawPassword);
            user.setPassword(encPassword);
            user.setRole(RoleType.USER);
            userRepository.save(user);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("" + e.getMessage());

        }

    }
    @Transactional
    public void 회원수정(User user) {
        // 수정시에는 영속성 컨텍스트 user 오브젝트를 영속화시키고 영속화된 user 오브젝트를 수정
        User persistance = userRepository.findById(user.getId()).orElseThrow(()->{
            return new IllegalArgumentException("회찾 실패");
        });
        String rawPassword = user.getPassword();
        String encPassword = encoder.encode(rawPassword);
        persistance.setPassword(encPassword);
        persistance.setEmail(user.getEmail());

    }
        // save 안해도 persistance 트랜잭션종료시 변경되었기때문에 db에 더티체킹이뤄져서 변경됌.
    // but sessison은 변경 안돼있음.
    }




    /*@Transactional(readOnly = true) // select 할떄 트랜잭션 시작 , 서비스 종료시에[ 트랜잭션 종료 정합성!
    public User 로그인(User user){
        return userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());
    }*/

