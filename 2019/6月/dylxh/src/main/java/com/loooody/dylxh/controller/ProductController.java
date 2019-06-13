package com.loooody.dylxh.controller;

import com.loooody.dylxh.VO.ProductInfoVO;
import com.loooody.dylxh.VO.ProductVO;
import com.loooody.dylxh.VO.RatingInfoVO;
import com.loooody.dylxh.VO.ResultVO;
import com.loooody.dylxh.entity.ProductCategory;
import com.loooody.dylxh.entity.ProductInfo;
import com.loooody.dylxh.entity.RatingInfo;
import com.loooody.dylxh.service.ProductCategoryService;
import com.loooody.dylxh.service.impl.ProductInfoServiceImpl;
import com.loooody.dylxh.service.impl.RatingInfoServiceImpl;
import com.loooody.dylxh.util.ResultVoUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: ProductController
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-3-11 上午11:43
 * @Version 1.0
 **/

@RestController
@RequestMapping("buyer/product")
public class ProductController {

    @Autowired
    private ProductInfoServiceImpl productInfoService;

    @Autowired
    private ProductCategoryService productCategoryService;

    @Autowired
    private RatingInfoServiceImpl ratingInfoService;

    @GetMapping("list")
    public ResultVO list(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control","no-cache");

        //1.查询所有的商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();

        //2.类目列表
        List<Integer> categoryTypeList = new ArrayList<>();
        for (ProductInfo productInfo : productInfoList) {
            categoryTypeList.add(productInfo.getCategoryType());
        }

        List<ProductCategory> productCategoryList = productCategoryService.findByProductTypeIn(categoryTypeList);



        //3.数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setDiscountType(productCategory.getDiscountType());
            productVO.setCategoryName(productCategory.getCategoryName());


            List<RatingInfo> ratingInfoList = new ArrayList<>();
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);


                    //将评论加入
                    List<RatingInfoVO> ratingInfoVOList = new ArrayList<>();
                    ratingInfoList = ratingInfoService.findByProductId(productInfo.getProductId());
                    for (RatingInfo ratingInfo : ratingInfoList) {
                        RatingInfoVO ratingInfoVO = new RatingInfoVO();
                        BeanUtils.copyProperties(ratingInfo, ratingInfoVO);
                        System.out.println(ratingInfoVO);
                        ratingInfoVOList.add(ratingInfoVO);
                    }
                    productInfoVO.setRatingInfoList(ratingInfoVOList);

                    productInfoVOList.add(productInfoVO);
                }
            }

            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVoUtil.success(productVOList);

    }
}
