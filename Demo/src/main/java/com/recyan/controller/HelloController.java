package com.recyan.controller;

import com.recyan.properties.Girlproperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Yan_Jiang on 2018/8/8.
 * Demo测试
 */
@RestController
@RequestMapping(value  = "/hello")
public class HelloController {

    /*@Value("${cupSize}") //取配置文件中的属性
    private String cupSize;

    @Value("${content}")
    private String content;*/

    @Autowired
    private Girlproperties girlproperties;

    @RequestMapping(value = "/say/{id}", method = RequestMethod.GET) //多个映射路径
    //@RequiredParam(value="id", required=false, defaultValue="0") //defaultValue需要字符串
    //@GetMapping --简化注解
    public String say(@PathVariable("id") Integer id) {
        return  "id: " + id;
    }
}
