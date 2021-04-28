package com.cos.blog.test;

import org.springframework.web.bind.annotation.GetMapping;

public class TempControllerTest {

    @GetMapping("/temp/home")
    public String tempHome() {
        return "/home.html";
    }
}

