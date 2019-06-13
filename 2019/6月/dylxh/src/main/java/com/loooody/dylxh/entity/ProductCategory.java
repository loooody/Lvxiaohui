package com.loooody.dylxh.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @ClassName: ProductCategory
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-3-8 下午5:34
 * @Version 1.0
 **/

@Entity
@DynamicUpdate
@Data
public class ProductCategory {

    //类目id
    @Id
    @GeneratedValue
    private Integer categoryId;

    //类目名字
    private String categoryName;

    //类目类型
    private Integer categoryType;

    //折扣类型
    private Integer discountType;

    private Date createTime;

    private Date updateTime;


}
