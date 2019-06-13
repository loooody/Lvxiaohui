package com.loooody.dylxh.entity;

import com.loooody.dylxh.enums.OrderStatusEnum;
import com.loooody.dylxh.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName: OrderInfo
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-3-11 下午2:47
 * @Version 1.0
 **/

@Entity
@Data
@DynamicUpdate
public class OrderInfo {

    /** 订单号 */
    @Id
    private String orderId;

    /** 买家姓名 */
    private String userName;

    /** 买家电话 */
    private String userPhone;

    /** 买家地址 */
    private String userAddress;

    /** 买家Openid */
    private String userOpenid;

    /** 订单数量 */
    private BigDecimal orderAmount;

    /** 订单状态，0为新订单 */
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /** 支付状态，0为未支付 */
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date updateTime;

}
