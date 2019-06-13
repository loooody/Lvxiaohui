package com.loooody.dylxh.service;

import com.loooody.dylxh.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryService {

    /**
     * 通过类目id查询类目实例
     *
     * @param categoryId
     * @return 类目实例
     */
    ProductCategory findOne(Integer categoryId);

    /**
     * 查询所有类目
     *
     * @return
     */
    List<ProductCategory> findAll();

    /**
     * 查询在categoryType集合中编号对应的类目实例
     *
     * @param categoryType
     * @return 类目实例列表
     */
    List<ProductCategory> findByProductTypeIn(List<Integer> categoryType);

    /**
     * 添加类目
     *
     * @param productCategory
     * @return 添加成功的类目实例
     */
    ProductCategory save(ProductCategory productCategory);
}
