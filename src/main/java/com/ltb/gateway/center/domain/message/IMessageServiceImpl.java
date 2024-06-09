package com.ltb.gateway.center.domain.message;

import com.ltb.gateway.center.application.IMessageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class IMessageServiceImpl implements IMessageService {

    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private Integer port;
    @Value("${spring.redis.password}")
    private String password;
    @Resource
    private Publisher publisher;

    @Override
    public Map<String, String> queryRedisConfig() {
        Map<String,String> result = new HashMap<>();
        result.put("host",host);
        result.put("port",String.valueOf(port));
        result.put("password",password);
        return result;
    }

    @Override
    public void pushMessage(String gatewayId, Object message) {
        publisher.publish(gatewayId,message);
    }
}
