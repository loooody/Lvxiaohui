package com.loooody.dylxh.aspect;

import com.loooody.dylxh.exception.SellerAuthorizeException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ClassName: AccessAspect
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-5-8 下午11:50
 * @Version 1.0
 **/

@Aspect
@Component
@Slf4j
public class AccessAspect {

    @Pointcut("execution(public * com.loooody.dylxh.controller.Order*.*(..))" +
            "&& !execution(public * com.loooody.dylxh.controller.Seller*.*(..))")
    public void verify() {}


    @Before("verify()")
    public void doVerify(){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = attributes.getResponse();

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers",
                "Origin, X-Requested-With, Content-Type, Accept");
        System.out.println("response header");
    }
}
