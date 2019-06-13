package com.loooody.dylxh.enums;

import lombok.Getter;

/**
 * @ClassName: PayStatusEnum
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-3-11 下午3:00
 * @Version 1.0
 **/

@Getter
public enum PayStatusEnum implements CodeEnum{

    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),
    ;

    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
