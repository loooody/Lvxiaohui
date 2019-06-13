package com.loooody.dylxh.service.impl;

import com.loooody.dylxh.entity.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceImplTest {

    @Autowired
    private ProductCategoryServiceImpl productCategoryService;

    @Test
    public void findOne() {
        ProductCategory productCategory = productCategoryService.findOne(1);
        Assert.assertEquals(new Integer(1), productCategory.getCategoryId());
    }

    @Test
    public void findAll() {
        List<ProductCategory> list = productCategoryService.findAll();
        Assert.assertNotEquals(0, ((List) list).size());
    }

    @Test
    public void findByProductTypeIn() {
        List<ProductCategory> productCategoryList = productCategoryService.findByProductTypeIn(Arrays.asList(1, 2, 3, 9));
        Assert.assertNotEquals(0, productCategoryList.size());
    }

    @Test
    public void save() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("nanjing");
        productCategory.setCategoryType(3);
    //    ProductCategory result = productCategoryService.save(productCategory);
    //    Assert.assertNotNull(result);

    }
}