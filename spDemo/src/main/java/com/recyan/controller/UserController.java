package com.recyan.controller;

import com.recyan.pojo.JSONResult;
import com.recyan.pojo.Resource;
import com.recyan.pojo.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Date;

/**
 * Created by Yan_Jiang on 2018/8/14.
 *
 */
@RestController
@RequestMapping(value = "/demo")
public class UserController {

    @Autowired
    private User user;

    @Autowired
    private Resource resource;

    @RequestMapping(value = "/getUser")
    public JSONResult getUser() {

        user.setName("eric");
        user.setAge(21);
        user.setBirthday(new Date());
        user.setPassword("root");
        user.setDesc("hello");

        return JSONResult.ok(user);
    }

    @RequestMapping(value = "/getResource")
    public JSONResult getResource() {

        /**
         * resource(@Autowired)是交给Spring创建的单实例对象，在项目启动时Spring就会按照注解配置给该对象赋值。
         * 而new出来的bean对象，虽然与resource使用的同样的class对象，但却是不同的加载方式，不会有初始值。
         */
        Resource bean = new Resource();

//        System.out.println(resource); 有值
//        System.out.println(bean);

        BeanUtils.copyProperties(resource, bean);

        return JSONResult.ok(bean);
    }


}
