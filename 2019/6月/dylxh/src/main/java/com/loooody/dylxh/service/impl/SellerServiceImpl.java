package com.loooody.dylxh.service.impl;

import com.loooody.dylxh.dao.SellerInfoDao;
import com.loooody.dylxh.entity.SellerInfo;
import com.loooody.dylxh.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: SellerServiceImpl
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-3-26 上午11:55
 * @Version 1.0
 **/

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoDao sellerInfoDao;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return sellerInfoDao.findByOpenid(openid);
    }

    @Override
    public SellerInfo findByUsername(String username) {
        return sellerInfoDao.findByUsername(username);
    }
}
