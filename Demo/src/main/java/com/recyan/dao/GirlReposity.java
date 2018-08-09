package com.recyan.dao;

import com.recyan.entity.Girl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Yan_Jiang on 2018/8/9.
 */
//JpaRepository<Girl, Integer> 对应表的类名 id类型
@Repository
public interface GirlReposity extends JpaRepository<Girl, Integer> {

    //通过年龄查询
    public List<Girl> fingbyAge(Integer age);
}
