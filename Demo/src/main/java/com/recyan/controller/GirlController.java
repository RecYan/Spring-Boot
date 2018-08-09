package com.recyan.controller;

import com.recyan.domain.Result;
import com.recyan.repository.GirlRepository;
import com.recyan.domain.Girl;
import com.recyan.service.GirlService;
import com.recyan.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Yan_Jiang on 2018/8/9.
 * 表的增删改查
 */
@RestController
@RequestMapping(value  = "/hello")
public class GirlController {

    private final static Logger logger =  LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private Girl girl;

    @Autowired
    private GirlService girlService;

    @Autowired
    private Result<Girl> result;

    /**
     * 查询女生列表
     * @return 女生列表
     */
    //@RequestMapping(value = "/girlList", method = RequestMethod.GET)
    @GetMapping(value = "/girlList")
    public List<Girl> girlList() {

        return girlRepository.findAll();

    }

    /**
     * 添加女生信息
     * @param girl 女生
     * @return 添加的女生
     */
    //@RequestMapping(value = "/addGirl", method = RequestMethod.POST)
    @PostMapping(value = "/girlAdd")
    // BindingResult bindingResult 验证注释的message内容
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {

       logger.info("girlAdd....");
        //验证未通过 打印错误信息
        if (bindingResult.hasErrors()) {

            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }

//        girl.setAge(girl.getAge());
//        girl.setCupSize(girl.getCupSize());

        return ResultUtil.success(girlRepository.save(girl));

        return result;

    }

    /**
     * 根绝id查询女生信息
     * @param id 女生id
     * @return 女生查询信息
     */
    @GetMapping(value = "/girlQueryById/{id}")
    public Girl girlQueryById(@PathVariable("id") Integer id) {

        return girlRepository.findOne(id);
    }

    /**
     * 根绝年龄查询女生列表<自定义实现>
     * @param age 年龄
     * @return 查询的女生列表
     */
    @GetMapping(value = "/girlQueryByAge/{age}")
    public List<Girl> girlQueryByAge(@PathVariable("age") Integer age) {

        return girlRepository.findByAge(age);
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
        return girlRepository.save(girl);
    }

    /**
     * 根绝id删除女生信息
     * @param id 女生id
     */
    @DeleteMapping(value = "/updateGirl/{id}")
    public void girlDelete(@PathVariable("id") Integer id) {

        girlRepository.delete(id);
    }

    @PostMapping(value = "/girlInsert")
    public void girlInsert() {

        girlService.insertGirl();
    }

}
