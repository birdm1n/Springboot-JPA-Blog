package com.cos.blog.test;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.function.Supplier;


@RestController
public class DummyControllerTest {
    @Autowired
    private UserRepository userRepository;

    @DeleteMapping("/dummy/user/{id}")
    public String delete(@PathVariable int id){
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            return "삭제 실패. 해당 id 존재하지 않음.";
        }
        return "삭제되었습니다 id :" + id;
    }

    @Transactional
    @PutMapping("/dummy/user/{id}") //json으로 받으려면 RequestBody 써야함.
    public User updateUser(@PathVariable int id, @RequestBody User requestUser){
        System.out.println("id : " + id);
        System.out.println("pw : " + requestUser.getPassword());
        System.out.println("email : " + requestUser.getEmail());

        User user = userRepository.findById(id).orElseThrow(()->{
            return new IllegalArgumentException("수정에 실패하였습니다.");
        });

        user.setPassword(requestUser.getPassword());
        user.setEmail(requestUser.getEmail());
        return user;


    }



    @GetMapping("/dummy/users")
    public List<User> list() {
        return userRepository.findAll();

    }

    //한페이지당 2건의 데이터를 리턴
    @GetMapping("/dummy/user")
    public List<User> pageList(@PageableDefault(size=1, sort="id", direction = Sort.Direction.DESC) Pageable pageable){
        Page<User> pagingUsers = userRepository.findAll(pageable);

        List<User> users = pagingUsers.getContent();
        return users;
    }

    @GetMapping("/dummy/user/{id}")
    public User detail(@PathVariable int id){
        User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
            @Override
            public IllegalArgumentException get() {
               return new IllegalArgumentException("해당 유저는 없습니다.");
            }
        });
        return user;
    }


    @PostMapping("/dummy/join")
    public String Join(User user){
        System.out.println("id:" + user.getId());
        System.out.println("id:" + user.getUsername());
        System.out.println("id:" + user.getPassword());
        System.out.println("id:" + user.getEmail());
        System.out.println("id:" + user.getRole());
        System.out.println("id:" + user.getCreateDate());

        user.setRole(RoleType.USER);
        userRepository.save(user);
        return "회원가입 완료";
    }
}
