package com.cos.blog.test;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // blog 패키지 이하 스캔해서 특정 어노테이션에 붙어 있는 클래스 파일들을 new해서(IOC) 스프링컨테이너에 관리.
public class BlogControllerTest {

    @GetMapping("/test/hello")
    public String hello(){
        return "<h1>hello spring boot</h1>";

    }

}


