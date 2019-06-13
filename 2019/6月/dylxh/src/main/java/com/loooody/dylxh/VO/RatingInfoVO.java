package com.loooody.dylxh.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName: RatingInfoVO
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-4-24 下午9:33
 * @Version 1.0
 **/

@Data
public class RatingInfoVO {

    /** 用户名 **/
    @JsonProperty("username")
    private String username;

    /** 评论类型 **/
    @JsonProperty("rateType")
    private Integer rateType;

    /** 评论时间 **/
    @JsonProperty("rateTime")
    private Date ratingTime;

    /** 评论内容 **/
    @JsonProperty("text")
    private String ratingText;

    /** 用户头像 **/
    @JsonProperty("avatar")
    private String avatar;

    @Override
    public String toString() {
        return "RatingInfoVO{" +
                "username='" + username + '\'' +
                ", rateType=" + rateType +
                ", ratingText='" + ratingText + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
