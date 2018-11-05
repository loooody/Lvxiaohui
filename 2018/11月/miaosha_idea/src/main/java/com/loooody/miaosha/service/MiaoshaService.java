package com.loooody.miaosha.service;

import com.loooody.miaosha.dao.GoodsDao;
import com.loooody.miaosha.domain.Goods;
import com.loooody.miaosha.domain.MiaoshaUser;
import com.loooody.miaosha.domain.OrderInfo;
import com.loooody.miaosha.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MiaoshaService {

    @Autowired
    GoodsService goodsService;

    @Autowired
    OrderService orderService;

    @Transactional
    public OrderInfo miaosha(MiaoshaUser user, GoodsVo goods) {
        //减少库存，下订单，写入秒杀订单
        goodsService.reduceStock(goods);

        //orderInfo miaosha_order
        return orderService.createOrder(user, goods);

    }

}
