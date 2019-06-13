package com.loooody.dylxh.dao;

import com.loooody.dylxh.entity.OrderInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderInfoDaoTest {

    @Autowired
    private OrderInfoDao orderInfoDao;

    private static final String OPENID ="110";


    @Test
    public void saveTest() {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderId("1234567");
        orderInfo.setUserName("loooody");
        orderInfo.setUserPhone("123456789");
        orderInfo.setUserAddress("dylxh");
        orderInfo.setUserOpenid(OPENID);
        orderInfo.setOrderAmount(new BigDecimal(1237.0));

        OrderInfo result = orderInfoDao.save(orderInfo);
        Assert.assertNotNull(result);

    }

    @Test
    public void findByBuyerOpenid() {

//        PageRequest request = new PageRequest(0, 3);
//
//        Page<OrderInfo> result = orderInfoDao.findByuserOpenid(OPENID, request);
//
//        Assert.assertNotEquals(0, result.getTotalElements());
    }
}