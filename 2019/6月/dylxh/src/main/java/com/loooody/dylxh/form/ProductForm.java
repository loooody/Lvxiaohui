package com.loooody.dylxh.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @ClassName: ProductForm
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-3-26 上午9:48
 * @Version 1.0
 **/

@Data
public class ProductForm {

    private String productId;

    /** 商品名称 */
    private String productName;

    /** 商品价格 */
    private BigDecimal productPrice;

    /** 商品库存 */
    private Integer productStock;

    /** 商品描述 */
    private String productDescription;

    /** 商品图片地址 */
    private String productIcon;

    /** 类目编号 */
    private Integer categoryType;

}
