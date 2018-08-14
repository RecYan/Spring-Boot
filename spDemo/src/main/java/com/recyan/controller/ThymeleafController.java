package com.recyan.controller;

import com.recyan.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Yan_Jiang on 2018/8/14.
 * 测试Thymeleaf 及相关标签
 */
@Controller
@RequestMapping(value = "/Thymeleaf")
public class ThymeleafController {

    @Autowired
    private User u;

    @Autowired
    private User u1;

    @Autowired
    private User u2;


    @RequestMapping(value = "/index")
    public String index(ModelMap map) {
        map.addAttribute("name", "thymeleaf-recyan");
        return "thymeleaf/index";
    }

    @RequestMapping(value = "/center")
    public String center() {
        return "thymeleaf/center/center";
    }

    @RequestMapping(value = "/test")
    public String test(ModelMap map) {


        u.setName("superadmin");
        u.setAge(10);
        u.setPassword("123465");
        u.setBirthday(new Date());
        u.setDesc("<font color='red'><b>hello world</b></font>");

        map.addAttribute("user", u);


        u1.setAge(19);
        u1.setName("jack");
        u1.setPassword("123456");
        u1.setBirthday(new Date());


        u2.setAge(17);
        u2.setName("LeeCX");
        u2.setPassword("123456");
        u2.setBirthday(new Date());

        List<User> userList = new ArrayList<>();
        userList.add(u);
        userList.add(u1);
        userList.add(u2);

        map.addAttribute("userList", userList);

        return "thymeleaf/test";
    }

    @PostMapping(value = "/postform")
    public String postform(User u) {

        System.out.println("姓名：" + u.getName());
        System.out.println("年龄：" + u.getAge());

        return "redirect:/Thymeleaf/test";
    }

}
