package com.loooody.dylxh.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.loooody.dylxh.entity.RatingInfo;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.List;

/**
 * @ClassName: ProductInfoVO
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-3-11 上午11:31
 * @Version 1.0
 **/

@Data
public class ProductInfoVO {

    @JsonProperty("id")
    private String productId;

    /** 商品名称 */
    @JsonProperty("name")
    private String productName;

    /** 商品价格 */
    @JsonProperty("price")
    private BigDecimal productPrice;

    /** 商品历史价格 **/
    @JsonProperty("oldPrice")
    private BigDecimal productOldPrice;

    /** 商品描述 */
    @JsonProperty("description")
    private String productDescription;

    /** 商品库存 */
    @JsonProperty("sellCount")
    private Integer sellCount;

    /** 商品详情 **/
    @JsonProperty("info")
    private String productInformation;

    /** 商品评论 **/
    @JsonProperty("ratings")
    private List<RatingInfoVO> ratingInfoList;

    /** 商品图片地址 */
    @JsonProperty("icon")
    private String productIcon;


}
