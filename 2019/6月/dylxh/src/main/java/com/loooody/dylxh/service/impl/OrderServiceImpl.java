package com.loooody.dylxh.service.impl;

import com.loooody.dylxh.converter.OrderInfoConverterOrderDTO;
import com.loooody.dylxh.dao.OrderDetailDao;
import com.loooody.dylxh.dao.OrderInfoDao;
import com.loooody.dylxh.dto.CartDTO;
import com.loooody.dylxh.dto.OrderDTO;
import com.loooody.dylxh.entity.OrderDetail;
import com.loooody.dylxh.entity.OrderInfo;
import com.loooody.dylxh.entity.ProductInfo;
import com.loooody.dylxh.enums.OrderStatusEnum;
import com.loooody.dylxh.enums.PayStatusEnum;
import com.loooody.dylxh.enums.ResultEnum;
import com.loooody.dylxh.exception.GlobalException;
import com.loooody.dylxh.service.OrderService;
import com.loooody.dylxh.service.ProductInfoService;
import com.loooody.dylxh.service.PushMessageService;
import com.loooody.dylxh.util.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.persistence.criteria.Order;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: OrderServiceImpl
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-3-11 下午4:19
 * @Version 1.0
 **/

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Autowired
    private OrderInfoDao orderInfoDao;

    @Autowired
    private PushMessageService pushMessageService;

    @Autowired
    private WebSocket webSocket;

    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {

        String orderId = KeyUtil.getUniqueKey();
        BigDecimal orderAmount = new BigDecimal(0);

        List<CartDTO> cartDTOList = new ArrayList<>();

        //1.查询商品
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            ProductInfo productInfo = productInfoService.findOne(orderDetail.getProductId());
            if (productInfo == null) {
                throw new GlobalException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            //2.计算订单总价
            orderAmount = productInfo.getProductPrice().
                    multiply(new BigDecimal(orderDetail.getProductQuantity()))
                    .add(orderAmount);
            //订单详情入库
            orderDetail.setDetailId(KeyUtil.getUniqueKey());
            orderDetail.setOrderId(orderId);
            BeanUtils.copyProperties(productInfo, orderDetail);
            orderDetailDao.save(orderDetail);

            cartDTOList.add(new CartDTO(orderDetail.getProductId(), orderDetail.getProductQuantity()));
        }

        //3.写入订单数据
        OrderInfo orderInfo = new OrderInfo();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO, orderInfo);

        orderInfo.setOrderAmount(orderAmount);
        orderInfoDao.save(orderInfo);

//        //4
//        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream().map(e->
//                    new CartDTO(e.getProductId(), e.getProductQuantity())
//        ).collect(Collectors.toList());;

        productInfoService.decreaseStock(cartDTOList);

        //发送websocket消息
        webSocket.sendMessage(orderId);

        return orderDTO;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        OrderInfo orderInfo = orderInfoDao.findOne(orderId);
        if (orderInfo == null) {
            throw new GlobalException(ResultEnum.ORDER_NOT_EXIST);
        }

        List<OrderDetail> orderDetailList = orderDetailDao.findByOrderId(orderId);
        if (CollectionUtils.isEmpty(orderDetailList)) {
            throw new GlobalException(ResultEnum.ORDERDETAIL_NOT_EXIST);
        }

        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderInfo, orderDTO);
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }

    @Override
    public List<OrderDTO> findList(String userOpenid) {
        List<OrderInfo> orderInfoList = orderInfoDao.findByuserOpenid(userOpenid);

        List<OrderDTO> orderDTOList = OrderInfoConverterOrderDTO.convert(orderInfoList);

        for (OrderDTO orderDTO : orderDTOList) {
            List<OrderDetail> orderDetailList = orderDetailDao.findByOrderId(orderDTO.getOrderId());
            orderDTO.setOrderDetailList(orderDetailList);
        }

        return orderDTOList;
    }

    @Override
    @Transactional
    public OrderDTO cancel(OrderDTO orderDTO) {
        OrderInfo orderInfo = new OrderInfo();

        //判断订单状态
        if (!orderDTO.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())) {
            log.error("订单状态不正确, orderId = {}, orderStatus = {}", orderDTO.getOrderId(), orderDTO.getOrderStatus());
            throw new GlobalException(ResultEnum.ORDER_STATUS_ERRRO);
        }

        //修改订单状态
        orderDTO.setOrderStatus(OrderStatusEnum.CANCEL.getCode());

        BeanUtils.copyProperties(orderDTO, orderInfo);

        OrderInfo updateResult = orderInfoDao.save(orderInfo);
        if (updateResult == null) {
            log.error("订单更新失败, orderInfo = {}", orderInfo);
            throw new GlobalException(ResultEnum.ORDER_UPDATE_FAIL);
        }

        //返回库存
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("订单中无商品信息. orderDTO = {}", orderDTO);
            throw new GlobalException(ResultEnum.ORDER_DETAIL_EMPTY);
        }

        List<CartDTO> cartDTOList = new ArrayList<>();
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            cartDTOList.add(new CartDTO(orderDetail.getProductId(), orderDetail.getProductQuantity()));
        }

        productInfoService.increaseStock(cartDTOList);

        if (orderDTO.getPayStatus().equals(PayStatusEnum.SUCCESS.getCode())) {
            //TODO
        }

        return orderDTO;
    }

    @Override
    @Transactional
    public OrderDTO finish(OrderDTO orderDTO) {

        //判断订单状态
        if (!orderDTO.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())) {
            log.error("订单状态不正确, orderId = {}, orderStatus = {}", orderDTO.getOrderId(), orderDTO.getOrderStatus());
            throw new GlobalException(ResultEnum.ORDER_STATUS_ERRRO);
        }

        //修改订单状态
        orderDTO.setOrderStatus(OrderStatusEnum.FINISHED.getCode());
        OrderInfo orderInfo = new OrderInfo();
        BeanUtils.copyProperties(orderDTO, orderInfo);
        OrderInfo updateResult = orderInfoDao.save(orderInfo);
        if (updateResult == null) {
            log.error("订单更新失败, orderInfo = {}", orderInfo);
            throw new GlobalException(ResultEnum.ORDER_UPDATE_FAIL);
        }

        //send wechat message
        pushMessageService.orderStatus(orderDTO);

        return orderDTO;
    }

    @Override
    @Transactional
    public OrderDTO paid(OrderDTO orderDTO) {
        //判断订单状态
        if (!orderDTO.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())) {
            log.error("订单状态不正确, orderId = {}, orderStatus = {}", orderDTO.getOrderId(), orderDTO.getOrderStatus());
            throw new GlobalException(ResultEnum.ORDER_STATUS_ERRRO);
        }

        //判断支付状态
        if (!orderDTO.getPayStatus().equals(PayStatusEnum.WAIT.getCode())) {
            log.error("订单支付状态不正确, orderDTO ={} ", orderDTO);
            throw new GlobalException(ResultEnum.ORDER_PAY_STATUS_ERROR);
        }

        //修改订单状态
        orderDTO.setPayStatus(PayStatusEnum.SUCCESS.getCode());
        OrderInfo orderInfo = new OrderInfo();
        BeanUtils.copyProperties(orderDTO, orderInfo);
        OrderInfo updateResult = orderInfoDao.save(orderInfo);
        if (updateResult == null) {
            log.error("订单更新失败, orderInfo = {}", orderInfo);
            throw new GlobalException(ResultEnum.ORDER_UPDATE_FAIL);
        }

        return orderDTO;
    }

    @Override
    public Page<OrderDTO> findList(Pageable pageable) {
        Page<OrderInfo> orderInfoPage = orderInfoDao.findAll(pageable);

        List<OrderDTO> orderDTOList = OrderInfoConverterOrderDTO.convert(orderInfoPage.getContent());

        return new PageImpl<>(orderDTOList, pageable, orderInfoPage.getTotalElements());
    }

}
