package com.loooody.dylxh;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName: LoggeerTest
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-2-27 下午7:30
 * @Version 1.0
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggeerTest {

    @Test
    public void test1(){
        String name = "lvxiaohui";
        String password = "123456";
        log.debug("debug....");
        log.info("info...");
        log.error("error....");
        log.info("name: {}, password {}", name, password);
    }
}
