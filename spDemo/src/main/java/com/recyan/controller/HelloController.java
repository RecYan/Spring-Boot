package com.recyan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Yan_Jiang on 2018/8/14.
 * spring boot 初体验
 */
@RestController
@RequestMapping(value = "/demo")
public class HelloController {

    @RequestMapping(value = "/hello")
    public String hello() {
        return "hello Spring Boot~~";
    }


}
