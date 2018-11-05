package com.loooody.miaosha.service;

import com.loooody.miaosha.dao.GoodsDao;
import com.loooody.miaosha.dao.MiaoshaUserDao;
import com.loooody.miaosha.domain.Goods;
import com.loooody.miaosha.domain.MiaoshaGoods;
import com.loooody.miaosha.domain.MiaoshaUser;
import com.loooody.miaosha.exception.GlobalException;
import com.loooody.miaosha.redis.MiaoshaUserKey;
import com.loooody.miaosha.redis.RedisService;
import com.loooody.miaosha.result.CodeMsg;
import com.loooody.miaosha.util.MD5Util;
import com.loooody.miaosha.util.UUIDUtil;
import com.loooody.miaosha.vo.GoodsVo;
import com.loooody.miaosha.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class GoodsService {

    @Autowired
    GoodsDao goodsDao;

    public List<GoodsVo> listGoodsVo(){
        return goodsDao.listGoodsVO();
    }

    public GoodsVo getGoodsVoByGoodsId(Long goodsId) {
        return goodsDao.getGoodsVoByGoodsId(goodsId);
    }

    public void reduceStock(GoodsVo goods) {
        MiaoshaGoods g = new MiaoshaGoods();
        g.setGoodsId(goods.getId());
        goodsDao.reduceStock(g);
    }
}
