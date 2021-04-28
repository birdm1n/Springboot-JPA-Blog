package com.cos.blog.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// 사용자가 요청 -> 응답(html파일)
// @Controoler

// 사용자가 요청 -> 응답(Data)
@RestController
public class HttpControllerTest {

    private static final String TAG = "HttpControllerTest:";

    @GetMapping("/http/lombok")
    public String lombokTest(){
        Member m = Member.builder().username("ssar").password("1234").email("ssar@nate.com").build();
        System.out.println(TAG + "getter : " + m.getUsername());
        m.setUsername("cos");
        System.out.println(TAG + "setter : " + m.getUsername());
        return "lombok test 완료";
    }

    @GetMapping("/http/post")
    public String postTest(){
        return "post 요청";
    }
    @GetMapping("/http/put")
    public String putTest(){
        return "put 요청";
    }

    @GetMapping("/http/delete")
    public String deleteTest(){
        return "delete 요청";
    }
}
