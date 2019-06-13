package com.loooody.dylxh.dao;

import com.loooody.dylxh.entity.RatingInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ClassName: RatingInfoDao
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-4-24 下午9:38
 * @Version 1.0
 **/

public interface RatingInfoDao extends JpaRepository<RatingInfo, String> {

    List<RatingInfo> findByProductId(String proudutId);

    List<RatingInfo> findAll();

}
