package com.loooody.dylxh.dao;

import com.loooody.dylxh.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: ProductCategoryDao
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-3-8 下午8:06
 * @Version 1.0
 **/

@Service
public interface ProductCategoryDao extends JpaRepository<ProductCategory, Integer> {

    /**
     * 查询在list集合中编号对应的类目实例
     * @param list
     * @return 类目实例列表
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> list);

}
