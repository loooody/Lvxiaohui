package com.loooody.dylxh.service.impl;

import com.loooody.dylxh.config.WechatAccountConfig;
import com.loooody.dylxh.dto.OrderDTO;
import com.loooody.dylxh.service.PushMessageService;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplate;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: PushMessageServiceImpl
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-3-27 下午1:51
 * @Version 1.0
 **/

@Service
@Slf4j
public class PushMessageServiceImpl implements PushMessageService {

    @Autowired
    private PushMessageService pushMessageService;

    @Autowired
    private WxMpService wxMpService;

    @Autowired
    private WechatAccountConfig accountConfig;

    @Override
    public void orderStatus(OrderDTO orderDTO) {
        WxMpTemplateMessage templateMessage = new WxMpTemplateMessage();
        templateMessage.setTemplateId(accountConfig.getTemplateId().get("orderStatus"));

     //   templateMessage.setToUser(orderDTO.getOrderId());
        templateMessage.setToUser("oZBhd1JFK-y1UW8XkQkqaHzK8IFI");

        List<WxMpTemplateData> data = Arrays.asList(
                new WxMpTemplateData("first","亲，请记得收货"),
                new WxMpTemplateData("keyword1",orderDTO.getUserName()),
                new WxMpTemplateData("keyword2","18888888888"),
                new WxMpTemplateData("keyword3",orderDTO.getOrderId()),
                new WxMpTemplateData("keyword4",orderDTO.getOrderStatusEnum().getMessage()),
                new WxMpTemplateData("keyword5","$" + orderDTO.getOrderAmount()),
                new WxMpTemplateData("remark","欢迎再次光临")
        );

        templateMessage.setData(data);

        try {
            wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        } catch (WxErrorException e) {
            log.info("微信模板消息，发送失败:{}", e);
        }
    }
}
