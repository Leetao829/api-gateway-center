package com.ltb.gateway.center.test;

import com.alibaba.fastjson.JSON;
import com.ltb.gateway.center.application.IConfigManageService;
import com.ltb.gateway.center.domain.manage.model.vo.GatewayServerVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigManageTest {

    private final Logger logger = LoggerFactory.getLogger(ConfigManageTest.class);

    @Resource
    private IConfigManageService configManageService;

    @Test
    public void test_queryGatewayServerList(){
        List<GatewayServerVO> gatewayServerVOList = configManageService.queryGatewayServerList();
        logger.info("网关服务信息为：{}", JSON.toJSONString(gatewayServerVOList));
    }

    @Test
    public void test_registerGatewayNode(){
        boolean res = configManageService.registerGatewayServerNode("10001", "api-gateway-g4", "电商配送网关", "127.0.0.198");
        logger.info("注册节点结果为：{}",res);
    }
}
