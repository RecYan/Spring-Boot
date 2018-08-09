package com.recyan.controller;

import com.recyan.dao.GirlReposity;
import com.recyan.entity.Girl;
import com.recyan.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Yan_Jiang on 2018/8/9.
 * 表的增删改查
 */
@RestController
@RequestMapping(value  = "/hello")
public class GirlController {

    @Autowired
    private GirlReposity girlReposity;

    @Autowired
    private Girl girl;

    @Autowired
    private GirlService girlService;

    /**
     * 查询女生列表
     * @return 女生列表
     */
    //@RequestMapping(value = "/girlList", method = RequestMethod.GET)
    @GetMapping(value = "/girlList")
    public List<Girl> girlList() {

        return girlReposity.findAll();

    }

    /**
     * 添加女生信息
     * @param cupSize cupSize
     * @param age 年龄
     * @return 添加的女生
     */
    //@RequestMapping(value = "/addGirl", method = RequestMethod.POST)
    @PostMapping(value = "/girlAdd")
    public Girl girlAdd(@RequestParam("cupSize") String cupSize,
                        @RequestParam("age") Integer age) {

        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlReposity.save(girl);

    }

    /**
     * 根绝id查询女生信息
     * @param id 女生id
     * @return 女生查询信息
     */
    @GetMapping(value = "/girlQueryById/{id}")
    public Girl girlQueryById(@PathVariable("id") Integer id) {

        return girlReposity.findOne(id);
    }

    /**
     * 根绝年龄查询女生列表<自定义实现>
     * @param age 年龄
     * @return 查询的女生列表
     */
    public List<Girl> girlQueryByAge(@PathVariable("age") Integer age) {

        return girlReposity.fingbyAge(age);
    }

    /**
     * 根据id更新女生信息
     * @param id 女生id
     * @param cupSize cupSize
     * @param age 年龄
     * @return 更新的女生信息
     */
    @PutMapping(value = "/girlUpdate/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age) {

        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlReposity.save(girl);
    }

    /**
     * 根绝id删除女生信息
     * @param id 女生id
     */
    @DeleteMapping(value = "/updateGirl/{id}")
    public void girlDelete(@PathVariable("id") Integer id) {

        girlReposity.delete(id);
    }

    @PostMapping(value = "/girlInsert")
    public void girlInsert() {

        girlService.insertGirl();
    }

}
