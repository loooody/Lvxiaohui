package com.loooody.dylxh.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @ClassName: AddressInfo
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-5-23 下午4:16
 * @Version 1.0
 **/

@Entity
@Data
public class AddressInfo {
    @Id
    @GeneratedValue
    private Integer id;

    //买家姓名
    private String username;

    //买家openid
    private String openid;

    //买家性别
    private Integer sex;

    //买家电话
    private String phone;

    //买家地址
    private String address;

    //买家门牌号
    private String addressInfo;
}
