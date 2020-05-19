package com.example.demo.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class TestController implements TestApi {

    @RequestMapping("/c")
    @Override
    public String test(@RequestParam(defaultValue = "everyone") String name) {
        return "hello " + name;
    }


    public static void main(String[] args) {
        String a = "a,b,c";
        String b = "b";
        String c = "c";
        List<String> strings = Arrays.asList(a.split(","));
        String[] aa = (String[]) strings.toArray();
        System.out.println(strings);
    }
}
