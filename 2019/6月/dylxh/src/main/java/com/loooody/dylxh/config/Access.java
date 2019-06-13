package com.loooody.dylxh.config;

import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: Access
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-5-8 下午9:19
 * @Version 1.0
 **/

public class Access {

    public static void access(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control","no-cache");
    }

}
