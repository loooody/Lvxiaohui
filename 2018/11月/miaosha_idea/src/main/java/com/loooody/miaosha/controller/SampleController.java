package com.loooody.miaosha.controller;

import com.loooody.miaosha.domain.User;
import com.loooody.miaosha.redis.UserKey;
import com.loooody.miaosha.result.CodeMsg;
import com.loooody.miaosha.result.Result;
import com.loooody.miaosha.redis.RedisService;
import com.loooody.miaosha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class SampleController {

    @Autowired
    UserService userService;

    @Autowired
    RedisService redisService;


    @RequestMapping("/thymeleaf")

    public String thymeleaf(Model model) {
        model.addAttribute("name", "miaosha");
        return "hello";
    }

    @RequestMapping("/hello")
    @ResponseBody
    public Result<String> hello() {
        return Result.success("hello,looody");
    }

    @RequestMapping("/helloError")
    @ResponseBody
    public Result<String> helloError() {
        return Result.error(CodeMsg.SERVER_ERROR);
    }

    @RequestMapping("/db/tx")
    @ResponseBody
    public Result<Boolean> dbGet() {
        userService.tx();
        return Result.success(true);
    }


    @RequestMapping("/redis/get")
    @ResponseBody
    public Result<User> get() {
        User user = redisService.get(UserKey.getById,"" + 1, User.class);

        return Result.success(user);
    }

    @RequestMapping("/redis/set")
    @ResponseBody
    public Result<Boolean> set() {
        User user = new User();
        user.setId(1);
        user.setName("1111");
        redisService.set(UserKey.getById, "" + 1, user);
        return Result.success(true);
    }
}
