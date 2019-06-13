package com.loooody.dylxh.service;

import com.loooody.dylxh.entity.AddressInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: AddressInfoService
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-5-23 下午4:54
 * @Version 1.0
 **/

public interface AddressInfoService {

    /**
     * 通过买家openid查询对应的地址
     * @param openid
     * @return
     */
    List<AddressInfo> findAddressInfoByOpenid(String openid);

    /**
     * 添加用户地址信息
     * @param addressInfo
     * @return
     */
    AddressInfo save(AddressInfo addressInfo);

}
