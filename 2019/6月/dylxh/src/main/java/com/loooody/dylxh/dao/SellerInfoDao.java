package com.loooody.dylxh.dao;

import com.loooody.dylxh.entity.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerInfoDao extends JpaRepository<SellerInfo, String> {

    SellerInfo findByOpenid(String openid);

    SellerInfo findByUsername(String username);

}
