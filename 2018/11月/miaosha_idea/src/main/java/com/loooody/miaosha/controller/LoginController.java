package com.loooody.miaosha.controller;

import com.loooody.miaosha.domain.User;
import com.loooody.miaosha.redis.RedisService;
import com.loooody.miaosha.redis.UserKey;
import com.loooody.miaosha.result.CodeMsg;
import com.loooody.miaosha.result.Result;
import com.loooody.miaosha.service.MiaoshaUserService;
import com.loooody.miaosha.service.UserService;
import com.loooody.miaosha.util.ValidatorUtil;
import com.loooody.miaosha.vo.LoginVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {

    private static Logger log = LoggerFactory.getLogger(LoginController.class);


    @Autowired
    MiaoshaUserService miaoshaUserService;

    @Autowired
    RedisService redisService;

    @RequestMapping("/to_login")
    public String Login() {
        return "login";
    }


    @RequestMapping("/do_login")
    @ResponseBody
    public Result<Boolean> doLogin(@Valid LoginVo loginVo) {
        log.info(loginVo.toString());

        //登录
        miaoshaUserService.login(loginVo);
        return Result.success(true);
    }
}
