package com.loooody.dylxh.service.impl;

import com.loooody.dylxh.dao.ProductCategoryDao;
import com.loooody.dylxh.entity.ProductCategory;
import com.loooody.dylxh.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: CategoryServiceImpl
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-3-11 上午9:43
 * @Version 1.0
 **/
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryDao productCategoryDao;



    @Override
    public ProductCategory findOne(Integer categoryId) {
        return productCategoryDao.findOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryDao.findAll();
    }

    @Override
    public List<ProductCategory> findByProductTypeIn(List<Integer> categoryType) {
        return productCategoryDao.findByCategoryTypeIn(categoryType);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryDao.save(productCategory);
    }

}
