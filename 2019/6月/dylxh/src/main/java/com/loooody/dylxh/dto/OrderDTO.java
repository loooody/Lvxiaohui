package com.loooody.dylxh.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.loooody.dylxh.entity.OrderDetail;
import com.loooody.dylxh.enums.OrderStatusEnum;
import com.loooody.dylxh.enums.PayStatusEnum;
import com.loooody.dylxh.util.EnumUtil;
import com.loooody.dylxh.util.serializer.DateToLongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: OrderDTO
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-3-11 下午4:05
 * @Version 1.0
 **/

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {

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
    @JsonSerialize(using = DateToLongSerializer.class)
    private Date createTime;

    /** 更新时间 */
    @JsonSerialize(using = DateToLongSerializer.class)
    private Date updateTime;

    List<OrderDetail> orderDetailList = new ArrayList<>();

    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum(){
        return EnumUtil.getByCode(orderStatus, OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum(){
        return EnumUtil.getByCode(payStatus, PayStatusEnum.class);
    }
}
