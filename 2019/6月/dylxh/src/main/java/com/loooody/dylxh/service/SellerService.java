package com.loooody.dylxh.service;

import com.loooody.dylxh.entity.SellerInfo;

/**
 * @ClassName: SellerService
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-3-26 上午11:53
 * @Version 1.0
 **/

public interface SellerService {

    /**
     * 通过openid查询卖家端信息
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);


    SellerInfo findByUsername(String username);

}
