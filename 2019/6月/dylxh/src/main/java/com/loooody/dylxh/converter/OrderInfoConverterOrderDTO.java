package com.loooody.dylxh.converter;

import com.loooody.dylxh.dao.OrderDetailDao;
import com.loooody.dylxh.dto.OrderDTO;
import com.loooody.dylxh.entity.OrderDetail;
import com.loooody.dylxh.entity.OrderInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: OrderInfoConverterOrderDTO
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-3-12 上午11:29
 * @Version 1.0
 **/

public class OrderInfoConverterOrderDTO {

    public static OrderDTO convert(OrderInfo orderInfo) {

        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderInfo, orderDTO);
        return orderDTO;

    }

    public static List<OrderDTO> convert(List<OrderInfo> orderInfoList) {
        List<OrderDTO> orderDTOList = new ArrayList<>();
        for (OrderInfo orderInfo : orderInfoList) {
            orderDTOList.add(convert(orderInfo));
        }

        return orderDTOList;
    }
}
