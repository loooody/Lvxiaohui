package com.loooody.dylxh.service.impl;

import com.loooody.dylxh.dao.AddressInfoDao;
import com.loooody.dylxh.entity.AddressInfo;
import com.loooody.dylxh.service.AddressInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: AddressInfoServiceImpl
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-5-23 下午4:56
 * @Version 1.0
 **/

@Service
@Slf4j
public class AddressInfoServiceImpl implements AddressInfoService {

    @Autowired
    private AddressInfoDao addressInfoDao;

    @Override
    public List<AddressInfo> findAddressInfoByOpenid(String openid) {
        return addressInfoDao.findAddressInfoByOpenid(openid);
    }

    @Override
    public AddressInfo save(AddressInfo addressInfo) {
        return addressInfoDao.save(addressInfo);
    }
}
