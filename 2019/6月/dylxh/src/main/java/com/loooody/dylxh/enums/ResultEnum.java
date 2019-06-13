package com.loooody.dylxh.enums;

import lombok.Getter;

/**
 * @ClassName: ResultEnum
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-3-11 下午4:29
 * @Version 1.0
 **/

@Getter
public enum ResultEnum {

    SUCCESS(0, "成功"),

    PARAM_ERROR(1, "参数错误"),

    PRODUCT_NOT_EXIST(10, "商品不存在"),

    ORDER_NOT_EXIST(11,"订单不存在"),

    ORDERDETAIL_NOT_EXIST(12,"订单详情不存在"),

    ORDER_STATUS_ERRRO(13,"订单状态不正确"),

    ORDER_UPDATE_FAIL(14, "订单更新失败"),

    ORDER_DETAIL_EMPTY(15, "订单中无商品信息"),

    ORDER_PAY_STATUS_ERROR(16, "订单支付状态不正确"),

    CART_EMPTY(17, "购物车为空"),

    ORDER_OWNER_ERROR(18, "订单不属于当前用户"),

    WECHAT_MP_ERROR(19, "微信错误"),

    ORDER_CANCEL_SUCCESS(20, "订单取消成功"),

    ORDER_FINISH_SUCCESS(21, "订单完结成功"),

    PRODUCT_STATUS_ERROR(22, "商品状态不正确"),

    OPENID_NOT_EXIST(23, "opneid不存在"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
