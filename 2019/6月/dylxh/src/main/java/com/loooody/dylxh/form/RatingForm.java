package com.loooody.dylxh.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * @ClassName: RatingForm
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-5-30 下午1:28
 * @Version 1.0
 **/

@Data
public class RatingForm {

    /** 商品Id **/
    @NotEmpty(message = "商品Id必填")
    private String orderIdList;

    /** 用户名 **/
    @NotEmpty(message = "用户名必填")
    private String username;

    /** 评论类型 **/
    @NotNull(message = "评论类型必填")
    private Integer rateType;

    /** 评论内容 **/
    private String ratingText;

    /** 用户头像 **/
    @NotEmpty(message = "用户头像必填")
    private String avatar;
}
