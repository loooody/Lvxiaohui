package com.loooody.dylxh.service.impl;

import com.loooody.dylxh.dao.ProductInfoDao;
import com.loooody.dylxh.dto.CartDTO;
import com.loooody.dylxh.entity.ProductInfo;
import com.loooody.dylxh.enums.ProductStatusEnum;
import com.loooody.dylxh.enums.ResultEnum;
import com.loooody.dylxh.exception.GlobalException;
import com.loooody.dylxh.service.ProductInfoService;
import jdk.nashorn.internal.objects.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: ProductInfoServiceImpl
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-3-11 上午11:38
 * @Version 1.0
 **/

@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoDao productInfoDao;

    @Override
    public ProductInfo findOne(String productId) {
        return productInfoDao.findOne(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoDao.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoDao.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoDao.save(productInfo);
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = productInfoDao.findOne(cartDTO.getProductId());
            if (productInfo == null) {
                throw new GlobalException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer sellCount = productInfo.getSellCount() - cartDTO.getProductQuantity();
            Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();

            productInfo.setProductStock(result);
            productInfo.setSellCount(sellCount);
            productInfoDao.save(productInfo);
        }
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = productInfoDao.findOne(cartDTO.getProductId());
            if (productInfo == null) {
                throw new GlobalException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer sellCount = productInfo.getSellCount() + cartDTO.getProductQuantity();
            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if(result < 0)
                throw new GlobalException(ResultEnum.PRODUCT_NOT_EXIST);

            productInfo.setProductStock(result);
            productInfo.setSellCount(sellCount);

            productInfoDao.save(productInfo);
        }

    }

    @Override
    public ProductInfo onSale(String productId) {
        ProductInfo productInfo = productInfoDao.findOne(productId);
        if (productInfo == null) {
            throw new GlobalException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if (productInfo.getProductStatusEnum() == ProductStatusEnum.UP) {
            throw new GlobalException(ResultEnum.PRODUCT_STATUS_ERROR);
        }

        //更新
        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());

        return productInfoDao.save(productInfo);
    }

    @Override
    public ProductInfo offSale(String productId) {
        ProductInfo productInfo = productInfoDao.findOne(productId);
        if (productInfo == null) {
            throw new GlobalException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if (productInfo.getProductStatusEnum() == ProductStatusEnum.DOWN) {
            throw new GlobalException(ResultEnum.PRODUCT_STATUS_ERROR);
        }

        //更新
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());

        return productInfoDao.save(productInfo);
    }
}
