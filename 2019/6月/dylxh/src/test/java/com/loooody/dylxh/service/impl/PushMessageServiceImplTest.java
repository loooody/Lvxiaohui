package com.loooody.dylxh.service.impl;

import com.loooody.dylxh.dto.OrderDTO;
import com.loooody.dylxh.service.OrderService;
import com.loooody.dylxh.service.PushMessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PushMessageServiceImplTest {

    @Autowired
    private PushMessageService pushMessageService;

    @Autowired
    private OrderService orderService;


    @Test
    public void orderStatus() throws Exception{

//        OrderDTO orderDTO = orderService.findOne("1552819255362783271");
//
//        pushMessageService.orderStatus(orderDTO);

    }
}