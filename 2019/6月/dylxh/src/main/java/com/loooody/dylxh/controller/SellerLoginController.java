package com.loooody.dylxh.controller;

import com.loooody.dylxh.entity.SellerInfo;
import com.loooody.dylxh.exception.GlobalException;
import com.loooody.dylxh.service.SellerService;
import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @ClassName: SellerLoginController
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-3-26 下午5:11
 * @Version 1.0
 **/

@RestController
@RequestMapping("/")
public class SellerLoginController {

    @Autowired
    private SellerService sellerService;

    /**
     * 管理员登录
     * @return
     */
    @GetMapping("/login")
    public ModelAndView loginIn(){
        return new ModelAndView("login");
    }


    /**
     * 卖家登录
     * @param username
     * @return
     */
    @PostMapping("/seller/login")
    public SellerInfo amdinLogin(@RequestParam("username") String username,
                                 HttpServletRequest request) {
        SellerInfo sellerInfo = new SellerInfo();
        if (!StringUtils.isEmpty(username)) {
            sellerInfo = sellerService.findByUsername(username);

            request.getSession().setAttribute("username", username);
        }
        return sellerInfo;
    }

    @GetMapping("/seller/logout")
    public ModelAndView logout(HttpServletRequest request){
        request.getSession().removeAttribute("username");

        return new ModelAndView("redirect:/login");
    }
}
