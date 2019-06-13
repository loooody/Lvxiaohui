package com.loooody.dylxh.controller;

import com.loooody.dylxh.VO.ResultVO;
import com.loooody.dylxh.entity.AddressInfo;
import com.loooody.dylxh.enums.ResultEnum;
import com.loooody.dylxh.exception.GlobalException;
import com.loooody.dylxh.form.AddressForm;
import com.loooody.dylxh.service.AddressInfoService;
import com.loooody.dylxh.service.impl.AddressInfoServiceImpl;
import com.loooody.dylxh.util.ResultVoUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @ClassName: AddressInfoController
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-5-23 下午5:00
 * @Version 1.0
 **/

@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/address")
public class AddressInfoController {

    @Autowired
    private AddressInfoServiceImpl addressInfoService;

    @GetMapping("/list")
    public ResultVO<AddressInfo> getList(@RequestParam("openid") String openid) {
        if (openid == null) {
            log.error("用户添加地址错误，地址信息为空");
            throw new GlobalException(ResultEnum.OPENID_NOT_EXIST);
        }
        List<AddressInfo> addressInfoList = addressInfoService.findAddressInfoByOpenid(openid);
        return ResultVoUtil.success(addressInfoList);
    }


    @PostMapping("/addr")
    public ResultVO<AddressInfo> add(@Valid @RequestBody String params) {
        net.sf.json.JSONObject jsonObject = net.sf.json.JSONObject.fromObject(params);
        System.out.println(jsonObject);
        AddressForm addressForm = (AddressForm) net.sf.json.JSONObject.toBean(jsonObject, AddressForm.class);
  //      System.out.println("AddressForm0: " + addressForm);
        if (addressForm == null) {
            throw new GlobalException(ResultEnum.OPENID_NOT_EXIST);
        }
        AddressInfo addressInfo = new AddressInfo();
        org.springframework.beans.BeanUtils.copyProperties(addressForm, addressInfo);
  //      System.out.println(addressInfo+ "\n" + addressForm);
        addressInfoService.save(addressInfo);
        return ResultVoUtil.success(addressInfo);
    }
}
