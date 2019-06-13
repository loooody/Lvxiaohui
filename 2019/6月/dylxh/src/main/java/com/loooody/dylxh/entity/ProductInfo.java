package com.loooody.dylxh.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.loooody.dylxh.enums.ProductStatusEnum;
import com.loooody.dylxh.util.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName: ProductInfo
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-3-11 上午10:07
 * @Version 1.0
 **/

@Entity
@Data
@DynamicUpdate
public class ProductInfo {

    @Id
    private String productId;

    /** 商品名称 */
    private String productName;

    /** 商品价格 */
    private BigDecimal productPrice;

    /** 商品历史价格 */
    private BigDecimal productOldPrice;

    /** 商品库存 */
    private Integer productStock;

    /** 商品销量 **/
    private Integer sellCount = 0;

    /** 商品描述 */
    private String productDescription;

    /** 商品图片地址 */
    private String productIcon;

    /** 商品状态（0正常，1下架） */
    private Integer productStatus = ProductStatusEnum.UP.getCode();

    /** 类目编号 */
    private Integer categoryType;

//    /** 评论id编号 **/
//    private Integer ratingId;

    /** 商品信息 **/
    private String productInformation;

    private Date createTime;

    private Date updateTime;

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum(){
        return EnumUtil.getByCode(productStatus, ProductStatusEnum.class);
    }
}
