package com.loooody.dylxh.dao;

import com.loooody.dylxh.entity.SellerInfo;
import com.loooody.dylxh.util.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoDaoTest {


    @Autowired
    private SellerInfoDao sellerInfoDao;

    @Test
    public void findByOpenId() {
//        SellerInfo sellerInfo = sellerInfoDao.findByOpenid("123");
//
//        Assert.assertEquals("123", sellerInfo.getOpenid());
    }

    @Test
    public void save(){
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setSellerId(KeyUtil.getUniqueKey());
        sellerInfo.setUsername("admin");
        sellerInfo.setPassword("admin");
        sellerInfo.setOpenid("123");

        SellerInfo result = sellerInfoDao.save(sellerInfo);
        Assert.assertNotEquals(null, result);
    }
}