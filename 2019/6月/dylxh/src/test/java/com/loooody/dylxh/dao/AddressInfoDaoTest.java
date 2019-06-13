package com.loooody.dylxh.dao;

import com.loooody.dylxh.entity.AddressInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressInfoDaoTest {

    @Autowired
    private AddressInfoDao addressInfoDao;

    @Test
    public void findAddressInfoByOpenid() {
        List<AddressInfo> addressInfo = addressInfoDao.findAddressInfoByOpenid("12345678");
        System.out.println(addressInfo.get(0).getOpenid());
    }

    @Test
    public void save(){
        AddressInfo addressInfo = new AddressInfo();
        addressInfo.setId(1);
        addressInfo.setUsername("lvxiaohui");
        addressInfo.setOpenid("12345678");
        addressInfo.setSex(0);
        addressInfo.setPhone("12345678910");
        addressInfo.setAddress("升升公寓");
        addressInfo.setAddressInfo("c栋");
        addressInfoDao.save(addressInfo);
    }
}