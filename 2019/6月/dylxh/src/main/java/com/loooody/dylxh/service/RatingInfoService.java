package com.loooody.dylxh.service;

import com.loooody.dylxh.entity.RatingInfo;

import java.util.List;

/**
 * @ClassName: RatingInfoService
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-4-24 下午9:46
 * @Version 1.0
 **/

public interface RatingInfoService {

    /**
     * 根据商品Id查询对应的评论列表
     * @param proudutId
     * @return
     */
    List<RatingInfo> findByProductId(String proudutId);

    List<RatingInfo> findAll();

    RatingInfo save(RatingInfo ratingInfo);

}
