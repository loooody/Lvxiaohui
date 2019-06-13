package com.loooody.dylxh.handler;

import com.loooody.dylxh.exception.SellerAuthorizeException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName: ExceptionHandler
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-3-26 下午10:24
 * @Version 1.0
 **/

@ControllerAdvice
public class SellerExceptionHandler {

    //拦截登录异常
    @ExceptionHandler(value = SellerAuthorizeException.class)
    public ModelAndView handlerAuthorizeException(){
        return new ModelAndView("redirect:/login");
    }

}
