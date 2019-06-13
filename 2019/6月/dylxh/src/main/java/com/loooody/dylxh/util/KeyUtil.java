package com.loooody.dylxh.util;

import java.util.Random;

/**
 * @ClassName: KeyUtil
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-3-11 下午5:27
 * @Version 1.0
 **/

public class KeyUtil {

    public static synchronized String getUniqueKey(){
        Random random = new Random();

        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
