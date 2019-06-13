package com.loooody.dylxh.service.impl;

import com.loooody.dylxh.dao.RatingInfoDao;
import com.loooody.dylxh.entity.RatingInfo;
import com.loooody.dylxh.service.RatingInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: RatingInfoServiceImpl
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-4-24 下午9:48
 * @Version 1.0
 **/

@Service
public class RatingInfoServiceImpl implements RatingInfoService {

    @Autowired
    private RatingInfoDao ratingInfoDao;

    @Override
    public List<RatingInfo> findByProductId(String proudutId) {
        return ratingInfoDao.findByProductId(proudutId);
    }

    @Override
    public List<RatingInfo> findAll() {
        return ratingInfoDao.findAll();
    }

    @Override
    public RatingInfo save(RatingInfo ratingInfo) {
        return ratingInfoDao.save(ratingInfo);
    }
}
