package com.loooody.dylxh.controller;

import com.loooody.dylxh.VO.ResultVO;
import com.loooody.dylxh.converter.OrderFormConvertOrderDTO;
import com.loooody.dylxh.dto.OrderDTO;
import com.loooody.dylxh.enums.ResultEnum;
import com.loooody.dylxh.exception.GlobalException;
import com.loooody.dylxh.form.OrderForm;
import com.loooody.dylxh.service.impl.BuyerServiceImpl;
import com.loooody.dylxh.service.impl.OrderServiceImpl;
import com.loooody.dylxh.util.ResultVoUtil;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSON;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @ClassName: OrderController
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-3-12 下午1:44
 * @Version 1.0
 **/

@RestController
@CrossOrigin
@RequestMapping("/buyer/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private BuyerServiceImpl buyerService;

    //创建订单
    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(@RequestBody String params,
                                                BindingResult bindingResult) throws JSONException {

        net.sf.json.JSONObject jsonObject = net.sf.json.JSONObject.fromObject(params);
        System.out.println(jsonObject);
        OrderForm orderForm = (OrderForm)net.sf.json.JSONObject.toBean(jsonObject, OrderForm.class);

        if (bindingResult.hasErrors()) {
            log.error("[创建订单]参数不正确,orderForm = {}", orderForm);
            throw new GlobalException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = OrderFormConvertOrderDTO.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("创建订单购物车不能为空");
            throw new GlobalException(ResultEnum.CART_EMPTY);
        }

        OrderDTO createResult = orderService.create(orderDTO);

        Map<String, String> map = new HashMap<>();

        map.put("orderId", createResult.getOrderId());
//
        return ResultVoUtil.success(map);

    }


    //订单列表
    @GetMapping("/list")
    public ResultVO<OrderDTO> list(@RequestParam("openid") String openid) {
        if (StringUtils.isEmpty(openid)) {
            log.error("[查询订单列表]openid为空");
            throw new GlobalException(ResultEnum.PARAM_ERROR);
        }

        List<OrderDTO> orderDTOList = orderService.findList(openid);

        return ResultVoUtil.success(orderDTOList);
    }

    //订单详情
    @GetMapping("/detail")
    public ResultVO<OrderDTO> detail(@RequestParam("openid") String openid,
                                     @RequestParam("orderId") String orderId) {

        OrderDTO orderDTO = buyerService.findOrderOne(openid, orderId);
        return ResultVoUtil.success(orderDTO);

    }

    // 取消订单
    @PostMapping("/cancel")
    public ResultVO cancle(@RequestParam("openid") String openid,
                           @RequestParam("orderId") String orderId) {

        buyerService.cancelOrder(openid, orderId);
        return ResultVoUtil.success();
    }

    // pay订单
    @GetMapping("/paid")
    public ResultVO pay(@RequestParam("openid") String openid,
                           @RequestParam("orderId") String orderId) {

        buyerService.payOrder(openid, orderId);
        return ResultVoUtil.success();
    }
}
