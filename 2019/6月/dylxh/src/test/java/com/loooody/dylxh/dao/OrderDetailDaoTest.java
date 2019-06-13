package com.loooody.dylxh.dao;

import com.loooody.dylxh.entity.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailDaoTest {

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Test
    public void testSave(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("1111");
        orderDetail.setOrderId("22222");
        orderDetail.setProductId("1234");
        orderDetail.setProductName("icon");
        orderDetail.setProductIcon("http:/***.jps");
        orderDetail.setProductPrice(new BigDecimal(1234));
        orderDetail.setProductQuantity(3);

        OrderDetail result = orderDetailDao.save(orderDetail);

        Assert.assertNotNull(result);

    }

    @Test
    public void findByOrderId() {
        List<OrderDetail> orderDetail = orderDetailDao.findByOrderId("1557498072309743377");

        Assert.assertNotEquals(0, orderDetail.size());
    }
}