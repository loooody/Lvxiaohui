package com.loooody.dylxh.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @ClassName: SellerInfo
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-3-26 上午11:35
 * @Version 1.0
 **/

@Data
@Entity
public class SellerInfo {

    @Id
    private String sellerId;

    private String username;

    private String password;

    private String openid;

}
