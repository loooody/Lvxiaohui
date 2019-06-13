package com.loooody.dylxh.util;

import com.loooody.dylxh.enums.CodeEnum;

/**
 * @ClassName: EnumUtil
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-3-25 下午3:23
 * @Version 1.0
 **/

public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
