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
 * @ClassName: SellerAuthorizeAspect
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-3-26 下午9:59
 * @Version 1.0
 **/

@Aspect
@Component
@Slf4j
public class SellerAuthorizeAspect {

    @Pointcut("execution(public * com.loooody.dylxh.controller.Seller*.*(..))" +
    "&& !execution(public * com.loooody.dylxh.controller.SellerLoginController.*(..))")
    public void verify() {}


    @Before("verify()")
    public void doVerify(){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //查询cookie
        HttpSession session = request.getSession();
        if (session.getAttribute("username") == null) {
            log.warn("【登录校验】Session中查不到session");
            throw new SellerAuthorizeException();
        }
    }
}
