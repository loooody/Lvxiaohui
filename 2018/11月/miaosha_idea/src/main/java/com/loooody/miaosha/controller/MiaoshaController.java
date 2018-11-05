package com.loooody.miaosha.controller;

import com.loooody.miaosha.domain.MiaoshaOrder;
import com.loooody.miaosha.domain.MiaoshaUser;
import com.loooody.miaosha.domain.OrderInfo;
import com.loooody.miaosha.redis.RedisService;
import com.loooody.miaosha.result.CodeMsg;
import com.loooody.miaosha.service.GoodsService;
import com.loooody.miaosha.service.MiaoshaService;
import com.loooody.miaosha.service.MiaoshaUserService;
import com.loooody.miaosha.service.OrderService;
import com.loooody.miaosha.vo.GoodsVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/miaosha")
public class MiaoshaController {

    private static Logger log = LoggerFactory.getLogger(MiaoshaController.class);


    @Autowired
    MiaoshaUserService miaoshaUserService;

    @Autowired
    RedisService redisService;

    @Autowired
    GoodsService goodsService;

    @Autowired
    OrderService orderService;

    @Autowired
    MiaoshaService miaoshaService;

    @RequestMapping("/do_miaosha")
    public String miaosha(Model model,MiaoshaUser miaoshaUser,
                        @RequestParam("goodsId") Long goodsId) {
        model.addAttribute("user", miaoshaUser);

        if (miaoshaUser == null) {
            return "login";
        }

        //判断库存
        GoodsVo goods = goodsService.getGoodsVoByGoodsId(goodsId);
        int stock = goods.getStockCount();
        if (stock <= 0) {

            model.addAttribute("errmsg", CodeMsg.MIAOSHA_OVER.getMsg());
            return "miaosha_fail";
        }

        //判断是否已经秒杀到了
        MiaoshaOrder order = orderService.getMiaoshaOrderByUserIdGoodsId(miaoshaUser.getId(), goodsId);
        if (order != null) {
            model.addAttribute("errmsg", CodeMsg.REPEATE_MIAOSHA.getMsg());
            return "miaosha_fail";
        }

        //减库存，订单，写入秒杀订单
        OrderInfo orderInfo = miaoshaService.miaosha(miaoshaUser, goods);
        model.addAttribute("orderInfo", orderInfo);
        model.addAttribute("goods", goods);

        //查询商品列表
        List<GoodsVo> goodsList = goodsService.listGoodsVo();
        model.addAttribute("goodsList", goodsList);

        return "order_detail";
    }



}
