package com.loooody.dylxh.VO;

import lombok.Data;

import javax.persistence.Entity;

/**
 * @ClassName: ResultVO
 * @Description: 前端返回的最外层数据
 * @Author: loooody
 * @Create: 19-3-11 上午11:31
 * @Version 1.0
 **/

@Data
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private T data;

}
