package com.loooody.dylxh.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @ClassName: WechatAccountConfig
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-3-23 上午11:24
 * @Version 1.0
 **/

@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {

    private String mpAppId;

    private String mpAppSecret;

    private Map<String, String> templateId;
}
