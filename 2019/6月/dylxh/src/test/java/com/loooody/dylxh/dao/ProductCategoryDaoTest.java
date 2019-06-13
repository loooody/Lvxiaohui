package com.loooody.dylxh.dao;

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
public class ProductCategoryDaoTest {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    public void findOneT(){
        ProductCategory category = productCategoryDao.findOne(1);
        System.out.println(category.toString());

    }

    @Test
    public void saveTest(){
        ProductCategory category = productCategoryDao.findOne(2);
        category.setCategoryType(9);
        productCategoryDao.save(category);
    }

    @Test
    public void testFindByCategoryTypeIn(){
        List<Integer> list = Arrays.asList(1, 2, 3,9);

        List<ProductCategory> result = productCategoryDao.findByCategoryTypeIn(list);

        Assert.assertNotEquals(0, result.size());
    }
}