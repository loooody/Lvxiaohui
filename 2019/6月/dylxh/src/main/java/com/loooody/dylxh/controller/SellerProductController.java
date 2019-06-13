package com.loooody.dylxh.controller;

import com.loooody.dylxh.dto.OrderDTO;
import com.loooody.dylxh.entity.ProductCategory;
import com.loooody.dylxh.entity.ProductInfo;
import com.loooody.dylxh.enums.ResultEnum;
import com.loooody.dylxh.exception.GlobalException;
import com.loooody.dylxh.form.ProductForm;
import com.loooody.dylxh.service.ProductCategoryService;
import com.loooody.dylxh.service.ProductInfoService;
import com.loooody.dylxh.util.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: SellerProductController
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-3-25 下午7:22
 * @Version 1.0
 **/

@Slf4j
@Controller
@RequestMapping("/seller/product")
public class SellerProductController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private ProductCategoryService productCategoryService;

    /**
     * 商品列表
     * @param page
     * @param size
     * @param map
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "6") Integer size,
                             Map<String, Object> map) {
        PageRequest request = new PageRequest(page - 1, size);
        Page<ProductInfo> productInfoPage = productInfoService.findAll(request);
        map.put("productInfoPage", productInfoPage);
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("product/list", map);
    }

    /**
     * 上架
     * @param productId
     * @param map
     * @return
     */
    @RequestMapping("/on_sale")
    public ModelAndView onSale(@RequestParam("productId") String productId,
                               Map<String, Object> map) {
        try {
            productInfoService.onSale(productId);
        } catch (GlobalException e) {
            log.info("[卖家端取消订单]订单异常", e);

            map.put("msg", e.getMessage());
            map.put("url", "/dylxh/seller/product/list");
            return new ModelAndView("common/error", map);
        }

        map.put("url", "/dylxh/seller/product/list");
        return new ModelAndView("common/success", map);
    }

    /**
     * 下架
     * @param productId
     * @param map
     * @return
     */
    @RequestMapping("/off_sale")
    public ModelAndView offSale(@RequestParam("productId") String productId,
                               Map<String, Object> map) {
        try {
            productInfoService.offSale(productId);
        } catch (GlobalException e) {
            log.info("[卖家端取消订单]订单异常", e);

            map.put("msg", e.getMessage());
            map.put("url", "/dylxh/seller/product/list");
            return new ModelAndView("common/error", map);
        }

        map.put("url", "/dylxh/seller/product/list");
        return new ModelAndView("common/success", map);
    }

    /**
     * 商品信息页面
     * @param productId
     * @param map
     * @return
     */
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(name = "productId", required = false) String productId,
                      Map<String, Object> map) {
        if (!StringUtils.isEmpty(productId)) {
            ProductInfo productInfo = productInfoService.findOne(productId);
            map.put("productInfo", productInfo);
        }

        //查询所有类目
        List<ProductCategory> productCategoryList = productCategoryService.findAll();
        map.put("productCategoryList", productCategoryList);

        return new ModelAndView("product/index", map);
    }

    /**
     * 保存/更新
     * @param form
     * @param bindingResult
     * @param map
     * @return
     */
    @PostMapping("/save")
    public ModelAndView save(@Valid ProductForm form,
                             BindingResult bindingResult,
                             Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/dylxh/seller/product/index");
            return new ModelAndView("common/error", map);
        }

        ProductInfo productInfo = new ProductInfo();
        try {
            //如果productid为空，说明是新增
            if (!StringUtils.isEmpty(form.getProductId())) {
                productInfo = productInfoService.findOne(form.getProductId());
            }else{
                form.setProductId(KeyUtil.getUniqueKey());
            }

            BeanUtils.copyProperties(form, productInfo);
            productInfoService.save(productInfo);
        } catch (GlobalException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/dylxh/seller/product/index");
            return new ModelAndView("common/error", map);
        }

        map.put("url", "/dylxh/seller/product/list");
        return new ModelAndView("common/success", map);
    }
}
