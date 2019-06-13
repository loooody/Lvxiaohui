package com.loooody.dylxh.dao;

import com.loooody.dylxh.entity.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoDaoTest {

    @Autowired
    private ProductInfoDao productInfoDao;

    @Test
    public void saveTest(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123");
        productInfo.setProductName("egg");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("this is a egg");
        productInfo.setProductIcon("wryiweo");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(2);

        ProductInfo result = productInfoDao.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void testfindByProductStatus(){
        List<ProductInfo> productInfoList = productInfoDao.findByProductStatus(0);
        for(ProductInfo productInfo : productInfoList)
            System.out.println(productInfo.toString());
        Assert.assertNotEquals(0, productInfoList.size());
    }

//    @Test
//    public void testUpdateSellCount(){
//        List<ProductInfo> productInfoList = productInfoDao.findAll();
//        for (ProductInfo productInfo : productInfoList) {
//            productInfo.setSellCount(0);
//            productInfo.setProductInformation(productInfo.getProductDescription());
//            productInfo.setRatingId(1);
//            productInfoDao.save(productInfo);
//        }
//    }
}