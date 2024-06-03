package com.ltb.gateway.center.test;

import com.alibaba.fastjson.JSON;
import com.ltb.gateway.center.application.IApiService;
import com.ltb.gateway.center.domain.model.ApiData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Resource
    private IApiService apiService;

    @Test
    public void test(){
        List<ApiData> apiDataList = apiService.queryHttpStatementList();
        logger.info("测试结果：{}", JSON.toJSON(apiDataList));
    }
}
