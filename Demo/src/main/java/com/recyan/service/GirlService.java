package com.recyan.service;

import com.recyan.dao.GirlReposity;
import com.recyan.entity.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Yan_Jiang on 2018/8/9.
 */
@Service
public class GirlService {

    @Autowired
    private GirlReposity girlReposity;

    @Autowired
    private Girl girlA;

    @Autowired
    private Girl girlB;

    @Transactional
    public void insertGirl() {

        girlA.setCupSize("B");
        girlA.setAge(20);
        girlReposity.save(girlA);

        girlB.setCupSize("D");
        int i = 1/0;
        girlB.setAge(23);
        girlReposity.save(girlB);
    }

}
