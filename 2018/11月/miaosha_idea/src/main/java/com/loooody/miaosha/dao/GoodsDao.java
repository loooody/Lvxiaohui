package com.loooody.miaosha.dao;

import com.loooody.miaosha.domain.Goods;
import com.loooody.miaosha.domain.MiaoshaGoods;
import com.loooody.miaosha.domain.User;
import com.loooody.miaosha.vo.GoodsVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodsDao {

    @Select("select g.*,mg.miaosha_price,mg.stock_count,mg.start_date,mg.end_date from miaosha_goods mg left join goods g on mg.goods_id = g.id")
    public List<GoodsVo> listGoodsVO();

    @Select("select g.*,mg.miaosha_price,mg.stock_count,mg.start_date,mg.end_date from miaosha_goods mg left join goods g on mg.goods_id = g.id where mg.goods_id = #{goodsId}")
    GoodsVo getGoodsVoByGoodsId(@Param("goodsId")Long goodsId);

    @Update("update miaosha_goods set stock_count = stock_count - 1 where goods_id = #{goodsId}")
    void reduceStock(MiaoshaGoods g);
}
