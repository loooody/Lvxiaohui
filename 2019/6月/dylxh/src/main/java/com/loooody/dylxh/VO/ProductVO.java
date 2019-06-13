package com.loooody.dylxh.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import java.util.List;

/**
 * @ClassName: ProductVO
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-3-11 上午11:31
 * @Version 1.0
 **/

@Data
public class ProductVO {

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer discountType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
