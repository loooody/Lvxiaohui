package com.loooody.dylxh.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @ClassName: OrderForm
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-3-12 下午1:46
 * @Version 1.0
 **/

@Data
public class OrderForm {

    @NotEmpty(message = "姓名必填")
    private String name;

    @NotEmpty(message = "手机号必填")
    private String phone;

    @NotEmpty(message = "地址必填")
    private String address;

    @NotEmpty(message = "openid必填")
    private String openid;

    @NotEmpty(message = "购物车不能为空")
    private String items;

}
