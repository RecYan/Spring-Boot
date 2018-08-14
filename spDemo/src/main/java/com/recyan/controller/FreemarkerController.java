package com.recyan.controller;

import com.recyan.pojo.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Yan_Jiang on 2018/8/14.
 * 测试freemarker
 */
@Controller
@RequestMapping(value = "/freemarker")
public class FreemarkerController {

    @Autowired
    private Resource resource;

    @RequestMapping(value = "/index") //ModelMap --> MVC中的ModelAndView
    public String index(ModelMap map) {

        map.addAttribute("resource", resource);
        return "freemarker/index";
    }

    @RequestMapping(value = "/center")
    public String center() {

        return "freemarker/center/center"; //后缀已经在application中配置好了
    }

}
