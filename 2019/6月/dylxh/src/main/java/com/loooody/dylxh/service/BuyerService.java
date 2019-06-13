package com.loooody.dylxh.service;

import com.loooody.dylxh.dto.OrderDTO;

public interface BuyerService {

    /**
     * 查询一个订单
     *
     * @param openid
     * @param orderId
     * @return 订单实例
     */
    OrderDTO findOrderOne(String openid, String orderId);


    /**
     * 取消订单
     *
     * @param openid
     * @param orderId
     * @return 订单实例
     */
    OrderDTO cancelOrder(String openid, String orderId);


    /**
     * pay订单
     *
     * @param openid
     * @param orderId
     * @return 订单实例
     */
    OrderDTO payOrder(String openid, String orderId);
}
