package com.loooody.dylxh.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * @ClassName: AddressForm
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-5-25 上午12:13
 * @Version 1.0
 **/

@Data
public class AddressForm {

    //买家姓名
    @NotEmpty(message = "姓名必填")
    private String username;

    //买家openid
    @NotEmpty(message = "openid必填")
    private String openid;

    //买家性别
    @NotNull(message = "性别必填")
    private Integer sex;

    //买家电话
    @NotEmpty(message = "买家电话必填")
    private String phone;

    //买家地址
    @NotEmpty(message = "买家地址必填")
    private String address;

    //买家门牌号
    private String addressInfo;
}
