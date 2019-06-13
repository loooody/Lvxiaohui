package com.loooody.dylxh.enums;

import lombok.Getter;

/**
 * @ClassName: ProductStatusEnum
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-3-11 下午12:31
 * @Version 1.0
 **/
@Getter
public enum ProductStatusEnum implements CodeEnum{

    UP(0,"在架"),
    DOWN(1,"下架");

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
