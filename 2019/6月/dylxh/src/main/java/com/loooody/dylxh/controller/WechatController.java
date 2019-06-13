package com.loooody.dylxh.controller;

import com.google.common.base.Utf8;
import com.loooody.dylxh.enums.ResultEnum;
import com.loooody.dylxh.exception.GlobalException;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @ClassName: WechatController
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-3-13 下午8:36
 * @Version 1.0
 **/


@Slf4j
@Controller
@CrossOrigin
@RequestMapping("/wechat")
public class WechatController {
    @GetMapping("/auth")
    public void auth(@RequestParam("code") String code) {
        log.info("进入验证");
        log.info("code={}", code);
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx6109375e3504ba33&secret=bcff4c19312a5edd6f73c26c70d5c61b&code=" + code + "&grant_type=authorization_code";

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        log.info("response={}", response);

    }
 //   https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx6109375e3504ba33&redirect_uri=http://kh4u4u.natappfree.cc/dylxh/wechat/userInfo&response_type=code&scope=snsapi_userinfo&state=STATE

    @Autowired
    private WxMpService wxMpService;

    @GetMapping("/authorize")
    public String authorize(@RequestParam("returnUrl") String returnUrl) {
        String url = "http://dylxh.natapp1.cc/dylxh/wechat/userInfo";
        String redirectUrl = null;

        try {

            redirectUrl = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAUTH2_SCOPE_USER_INFO, URLEncoder.encode(returnUrl,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(redirectUrl);

         return "redirect:" + redirectUrl;
    }

    @GetMapping("/userInfo")
    public String userInfo(@RequestParam("code") String code,
                         @RequestParam("state") String returnUrl){
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
        try{
            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
        }catch(WxErrorException e){
            log.error("[微信网页授权】 {} ", e);
            throw new GlobalException(ResultEnum.WECHAT_MP_ERROR.getCode(), e.getError().getErrorMsg());


        }
        System.out.println(returnUrl);
        String oppenId = wxMpOAuth2AccessToken.getOpenId();

        return "redirect:" + returnUrl + "?openid=" + oppenId;
    }
}

