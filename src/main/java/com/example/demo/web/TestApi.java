package com.example.demo.web;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/a")
public interface TestApi {
    @RequestMapping("b")
    String test(String name);
}
