package com.loooody.dylxh.exception;

import com.loooody.dylxh.enums.ResultEnum;

/**
 * @ClassName: GlobalException
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-3-11 下午4:28
 * @Version 1.0
 **/

public class GlobalException extends RuntimeException{

    private Integer code;

    public GlobalException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public GlobalException(Integer code, String message) {
        super(message);

        this.code = code;
    }
}
