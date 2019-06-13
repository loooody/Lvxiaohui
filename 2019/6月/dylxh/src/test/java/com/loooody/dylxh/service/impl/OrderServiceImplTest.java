package com.loooody.dylxh.service.impl;

import com.loooody.dylxh.dto.OrderDTO;
import com.loooody.dylxh.entity.OrderDetail;
import com.loooody.dylxh.enums.OrderStatusEnum;
import com.loooody.dylxh.enums.PayStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

//    @Autowired
//    private OrderServiceImpl orderService;
//
//    private final String BUYER_OPENID = "110112";
//
//    private final String ORDER_ID = "1552360120460179198";
//
//    @Test
//    public void create() {
//        OrderDTO orderDTO = new OrderDTO();
//        orderDTO.setUserName("loooody");
//        orderDTO.setUserAddress("shanghai");
//        orderDTO.setUserPhone("123456789");
//        orderDTO.setUserOpenid(BUYER_OPENID);
//
//        List<OrderDetail> orderDetailList = new ArrayList<>();
//
//        OrderDetail orderDetail = new OrderDetail();
//        orderDetail.setProductId("123");
//        orderDetail.setProductQuantity(1);
//
//        OrderDetail orderDetail1 = new OrderDetail();
//        orderDetail1.setProductId("1234");
//        orderDetail1.setProductQuantity(10);
//
//
//        orderDetailList.add(orderDetail);
//        orderDetailList.add(orderDetail1);
//
//        orderDTO.setOrderDetailList(orderDetailList);
//
//        OrderDTO result = orderService.create(orderDTO);
//        log.info("create order = {}", result);
//    }
//
    @Test
    public void findOne() {
//        OrderDTO result = orderService.findOne(ORDER_ID);
//        log.info("order detail : {}", result);
    }
//
//    @Test
//    public void findList() {
//        PageRequest request = new PageRequest(0, 2);
//        Page<OrderDTO> orderDTOPage = orderService.findList(BUYER_OPENID, request);
//
//        Assert.assertNotEquals(0, orderDTOPage.getTotalElements());
//    }
//
//    @Test
//    public void cancel() {
//    //    OrderDTO orderDTO = orderService.findOne(ORDER_ID);
//    //    OrderDTO result = orderService.cancel(orderDTO);
//   //     Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(), result.getOrderStatus());
//    }
//
//    @Test
//    public void finish() {
//   //     OrderDTO orderDTO = orderService.findOne(ORDER_ID);
//   //     OrderDTO result = orderService.finish(orderDTO);
//    //    Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(), result.getOrderStatus());
//    }
//
//    @Test
//    public void paid() {
//   //     OrderDTO orderDTO = orderService.findOne(ORDER_ID);
//    //    OrderDTO result = orderService.paid(orderDTO);
//    //    Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(), result.getPayStatus());
//    }
//
//    @Test
//    public void list(){
//        PageRequest request = new PageRequest(0, 2);
//        Page<OrderDTO> orderDTOPage = orderService.findList(request);
//        Assert.assertEquals(0, orderDTOPage.getTotalElements());
//    }
}