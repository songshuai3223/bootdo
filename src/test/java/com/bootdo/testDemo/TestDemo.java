package com.bootdo.testDemo;

import com.bootdo.common.utils.SpringContextHolder;
import com.bootdo.system.domain.TableDO;
import com.bootdo.system.service.TableService;
import com.bootdo.system.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@WebAppConfiguration
@SpringBootTest
public class TestDemo {
    @Test
    public void testTemp(){
        TableService tableService=SpringContextHolder.getBean(TableService.class);
        List<TableDO> list=new ArrayList<>();
        TableDO tableDO1=tableService.get("1");
        tableDO1.setPassword("pass01");
        list.add(tableDO1);

        TableDO tableDO2=tableService.get("2");
        tableDO2.setPassword("pass02");
        list.add(tableDO2);

        TableDO tableDO3=tableService.get("3");
        tableDO3.setPassword("pass03");
        list.add(tableDO3);
        tableService.batchUpdate(list);
    }

}