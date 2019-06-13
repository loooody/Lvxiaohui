package com.loooody.dylxh.service;

import com.loooody.dylxh.dto.OrderDTO;

/**
 * @ClassName: PushMessageService
 * @Description:
 * @Author: loooody
 * @Create: 19-3-27 下午1:01
 * @Version 1.0
 **/

public interface PushMessageService {

    void orderStatus(OrderDTO orderDTO);

}
