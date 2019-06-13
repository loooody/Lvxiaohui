package com.loooody.dylxh.dto;

import lombok.Data;

/**
 * @ClassName: CartDTO
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-3-12 上午9:13
 * @Version 1.0
 **/

@Data
public class CartDTO {

    /** */
    private String productId;

    /** */
    private Integer productQuantity;

    public CartDTO(){

    }

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
