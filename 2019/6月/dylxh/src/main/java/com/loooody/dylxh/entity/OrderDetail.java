package com.loooody.dylxh.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName: OrderDetail
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-3-11 下午3:04
 * @Version 1.0
 **/

@Entity
@Data
@DynamicUpdate
public class OrderDetail {

    @Id
    private String detailId;

    /** 订单号 */
    private String orderId;

    /** 商品id */
    private String productId;

    /** 商品名称 */
    private String productName;

    /** 商品价格 */
    private BigDecimal productPrice;

    /** 商品数量 */
    private Integer productQuantity;

    /** 商品图标 */
    private String productIcon;

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date updateTime;


}
