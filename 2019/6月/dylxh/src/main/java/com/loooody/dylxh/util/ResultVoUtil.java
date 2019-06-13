package com.loooody.dylxh.util;

import com.loooody.dylxh.VO.ResultVO;

/**
 * @ClassName: ResultVoUtil
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-3-11 上午11:26
 * @Version 1.0
 **/

public class ResultVoUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVo = new ResultVO();
        resultVo.setData(object);
        resultVo.setCode(0);
        resultVo.setMsg("success");
        return resultVo;
    }

    public static ResultVO success(){
        return success(null);
    }

    public static ResultVO error(Integer code, String msg) {
        ResultVO resultVo = new ResultVO();
        resultVo.setCode(code);
        resultVo.setMsg(msg);
        return resultVo;
    }
}
