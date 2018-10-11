package com.bootdo.testDemo;

import com.bootdo.common.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@WebAppConfiguration
@SpringBootTest
public class TestDemo {
    @Autowired
    private RedisUtil redisUtil;
    @Test
    public void testTemp(){
        redisUtil.set("key","value",0);
        String value=redisUtil.get("key",0).toString();
        System.out.println(value);
    }
}