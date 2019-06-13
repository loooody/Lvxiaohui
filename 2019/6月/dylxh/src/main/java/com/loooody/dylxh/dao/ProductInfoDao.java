package com.loooody.dylxh.dao;

import com.loooody.dylxh.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInfoDao extends JpaRepository<ProductInfo, String> {

    /**
     * 通过商品状态查询在架商品
     * @param productStatus
     * @return 再架商品列表
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);

}
