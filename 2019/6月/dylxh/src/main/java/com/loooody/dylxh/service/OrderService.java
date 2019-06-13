package com.loooody.dylxh.service;

import com.loooody.dylxh.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderService {

    /**
     * 创建订单
     *
     * @param orderDTO
     * @return 订单实例
     */
    OrderDTO create(OrderDTO orderDTO);

    /**
     * 查询每个订单
     *
     * @param orderId
     * @return
     */
    OrderDTO findOne(String orderId);

    /**
     * 查询订单列表
     *
     * @param userOpenid
     * @return
     */
    List<OrderDTO> findList(String userOpenid);

    /**
     * 取消订单
     *
     * @param orderDTO
     * @return
     */
    OrderDTO cancel(OrderDTO orderDTO);

    /**
     * 完结订单
     *
     * @param orderDTO
     * @return
     */
    OrderDTO finish(OrderDTO orderDTO);

    /**
     * 支付订单
     *
     * @param orderDTO
     * @return
     */
    OrderDTO paid(OrderDTO orderDTO);

    /**
     * 查询订单列表
     *
     * @param pageable
     * @return
     */
    Page<OrderDTO> findList(Pageable pageable);
}
