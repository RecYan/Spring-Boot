package com.recyan.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by Yan_Jiang on 2018/8/14.
 * 资源文件 resource.properties
 */
@Configuration //引用资源文件标识
@ConfigurationProperties(prefix = "com.recyan.opensource") //资源文件前缀
@PropertySource(value = "classpath:resource.properties") // 资源文件位置
public class Resource {

    private String name;

    private String website;

    private String language;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "name='" + name + '\'' +
                ", website='" + website + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
