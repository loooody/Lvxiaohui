package com.loooody.dylxh.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @ClassName: RatingInfo
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-4-24 下午9:21
 * @Version 1.0
 **/

@Entity
@Data
@DynamicUpdate
public class RatingInfo {

    /** 评论id **/
    @Id
    private String ratingId;

    /** 商品Id **/
    private String productId;

    /** 用户名 **/
    private String username;

    /** 评论类型 **/
    private Integer rateType;

    /** 评论内容 **/
    private String ratingText;

    /** 用户头像 **/
    private String avatar;

    /** 评论时间 **/
    private Date ratingTime;

}
