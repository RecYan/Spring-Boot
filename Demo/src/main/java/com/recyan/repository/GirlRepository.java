package com.recyan.repository;

import com.recyan.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Yan_Jiang on 2018/8/9.
 */
//JpaRepository<Girl, Integer> 对应表的类名 id类型
@Repository
public interface GirlRepository extends JpaRepository<Girl, Integer> {

    //通过年龄查询 --- 注意方法名的格式
    List<Girl> findByAge(Integer age);
}
