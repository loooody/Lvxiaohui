package com.loooody.dylxh.service;

import com.loooody.dylxh.dto.CartDTO;
import com.loooody.dylxh.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductInfoService {

    /**
     * 根据商品id查询商品
     * @param productId
     * @return 商品信息
     */
    ProductInfo findOne(String productId);

    /**
     * 查询所有在架商品
     * @return 在架商品列表
     */
    List<ProductInfo> findUpAll();

    /**
     * 根据分页信息查询商品
     * @param pageable
     * @return 商品信息
     */
    Page<ProductInfo> findAll(Pageable pageable);

    /**
     * 添加商品信息
     * @param productInfo
     * @return 添加成功的商品信息
     */
    ProductInfo save(ProductInfo productInfo);

    /**
     * 增加库存
     * @param cartDTOList
     */
    void increaseStock(List<CartDTO> cartDTOList);

    /**
     * 减少库存
     * @param cartDTOList
     */
    void decreaseStock(List<CartDTO> cartDTOList);

    /**
     * 上架
     * @param productId
     * @return
     */
    ProductInfo onSale(String productId);

    /**
     * 下架
     * @param productId
     * @return
     */
    ProductInfo offSale(String productId);
}
