package com.loooody.dylxh.service.impl;

import com.loooody.dylxh.dto.OrderDTO;
import com.loooody.dylxh.enums.ResultEnum;
import com.loooody.dylxh.exception.GlobalException;
import com.loooody.dylxh.service.BuyerService;
import com.loooody.dylxh.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.id.CompositeNestedGeneratedValueGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: BuyerServiceImpl
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-3-12 下午5:20
 * @Version 1.0
 **/

@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private OrderService orderService;

    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {
        return checkOrderOwner(openid, orderId);
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO = checkOrderOwner(openid, orderId);
        if (orderDTO == null) {
            log.error("[取消订单]查不到该订单, orderId = {}", orderId);
            throw new GlobalException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.cancel(orderDTO);
    }

    @Override
    public OrderDTO payOrder(String openid, String orderId) {
        OrderDTO orderDTO = checkOrderOwner(openid, orderId);
        if (orderDTO == null) {
            log.error("[取消订单]查不到该订单, orderId = {}", orderId);
            throw new GlobalException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.paid(orderDTO);
    }

    private OrderDTO checkOrderOwner(String openid, String orderId) {
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            return null;
        }
        //判断是否是自己的订单
        if (!orderDTO.getUserOpenid().equalsIgnoreCase(openid)) {
            log.error("[查询订单]openid与用户不一致, openid = {}", openid);
            throw new GlobalException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }
}
