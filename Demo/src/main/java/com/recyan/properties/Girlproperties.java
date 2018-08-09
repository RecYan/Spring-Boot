package com.recyan.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by Yan_Jiang on 2018/8/8.
 * 配置文件中girl属性实体
 */
@Component
@PropertySource("classpath:application.yml") //SpringBoot 1.5以上版本取消 @ConfigurationProperties中location属性，这里用@PropertySource代替
@ConfigurationProperties(prefix = "girl")
public class Girlproperties {

    private String cupSize;

    private Integer age;

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
