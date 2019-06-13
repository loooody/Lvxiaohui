package com.loooody.dylxh.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loooody.dylxh.dto.OrderDTO;
import com.loooody.dylxh.entity.OrderDetail;
import com.loooody.dylxh.enums.ResultEnum;
import com.loooody.dylxh.exception.GlobalException;
import com.loooody.dylxh.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @ClassName: OrderFormConvertOrderDTO
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-3-12 下午2:00
 * @Version 1.0
 **/

@Slf4j
public class OrderFormConvertOrderDTO {

    public static OrderDTO convert(OrderForm orderForm) {
        Gson gson = new Gson();

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setUserName(orderForm.getName());
        orderDTO.setUserPhone(orderForm.getPhone());
        orderDTO.setUserAddress(orderForm.getAddress());
        orderDTO.setUserOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>() {
            }.getType());
        } catch (Exception e) {
            log.error("[对象转换]错误, String = {}", orderForm.getItems());
            throw new GlobalException(ResultEnum.PARAM_ERROR);
        }

        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }
}
