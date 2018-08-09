package com.recyan.entity;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Yan_Jiang on 2018/8/9.
 * 数据库对应的表
 */
@Entity
@Component
public class Girl {

    @Id
    @GeneratedValue //自增
    private Integer id;

    private String cupSize;

    private Integer age;

    //无参构造必须要有
    public Girl() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
