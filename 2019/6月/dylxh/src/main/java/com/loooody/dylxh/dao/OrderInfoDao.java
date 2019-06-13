package com.loooody.dylxh.dao;

import com.loooody.dylxh.entity.OrderInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderInfoDao extends JpaRepository<OrderInfo, String> {

    /**
     * 通过用户的openid来进行用户订单查询
     *
     * @param buyerOpenid
     * @return 用户订单
     */
    List<OrderInfo> findByuserOpenid(String buyerOpenid);

}
