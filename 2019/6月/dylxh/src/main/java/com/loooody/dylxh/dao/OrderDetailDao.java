package com.loooody.dylxh.dao;

import com.loooody.dylxh.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailDao extends JpaRepository<OrderDetail, String> {

    /**
     * 通过订单id查询订单详情
     *
     * @param orderId
     * @return 订单详情列表
     */
    List<OrderDetail> findByOrderId(String orderId);

}
