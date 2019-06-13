package com.loooody.dylxh.controller;

import com.loooody.dylxh.VO.ResultVO;
import com.loooody.dylxh.entity.RatingInfo;
import com.loooody.dylxh.enums.ResultEnum;
import com.loooody.dylxh.exception.GlobalException;
import com.loooody.dylxh.form.RatingForm;
import com.loooody.dylxh.service.RatingInfoService;
import com.loooody.dylxh.util.KeyUtil;
import com.loooody.dylxh.util.ResultVoUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @ClassName: RatingController
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-5-14 下午11:30
 * @Version 1.0
 **/

@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/buyer/rating")
public class RatingController {
    @Autowired
    private RatingInfoService ratingInfoService;

    @GetMapping("/list")
    public ResultVO<RatingInfo> findRating() {
        List<RatingInfo> ratingInfoList = ratingInfoService.findAll();
        return ResultVoUtil.success(ratingInfoList);
    }

    @PostMapping("/create")
    public ResultVO addRating(@Valid @RequestBody String params){
        net.sf.json.JSONObject jsonObject = net.sf.json.JSONObject.fromObject(params);
        System.out.println(jsonObject);
        RatingForm ratingForm = (RatingForm) net.sf.json.JSONObject.toBean(jsonObject, RatingForm.class);
        System.out.println("rating: " + ratingForm.toString());
        if (ratingForm == null) {
            throw new GlobalException(ResultEnum.OPENID_NOT_EXIST);
        }
        String orderIdList = ratingForm.getOrderIdList();
        String[] productId = orderIdList.split(",");
        for (String str : productId) {
            String ratingId = KeyUtil.getUniqueKey();
            RatingInfo ratingInfo = new RatingInfo();
            org.springframework.beans.BeanUtils.copyProperties(ratingForm, ratingInfo);
            ratingInfo.setProductId(str);
            ratingInfo.setRatingId(ratingId);
            System.out.println(ratingInfo);
            ratingInfoService.save(ratingInfo);
            System.out.println(str);
        }

        return ResultVoUtil.success();
    }
}
