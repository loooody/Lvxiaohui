package com.loooody.dylxh.dao;

import com.loooody.dylxh.entity.AddressInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ClassName: AddressInfoDao
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-5-23 下午4:31
 * @Version 1.0
 **/

public interface AddressInfoDao extends JpaRepository<AddressInfo, Integer> {

    /**
     * 通过买家openid查询对应的地址
     * @param openid
     * @return
     */
    List<AddressInfo> findAddressInfoByOpenid(String openid);


}
