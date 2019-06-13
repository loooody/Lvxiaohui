package com.loooody.dylxh.enums;

import lombok.Getter;

/**
 * @ClassName: OrderStatusEnum
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-3-11 下午12:31
 * @Version 1.0
 **/

@Getter
public enum OrderStatusEnum implements CodeEnum{

    NEW(0, "新订单"),
    FINISHED(1, "完结"),
    CANCEL(2, "已取消"),
    ;

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
