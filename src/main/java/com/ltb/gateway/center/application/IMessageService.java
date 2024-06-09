package com.ltb.gateway.center.application;

import java.util.Map;

/**
 * 消息服务
 *
 * @author leetao
 */
public interface IMessageService {

    Map<String,String> queryRedisConfig();

    void pushMessage(String gatewayId,Object message);
}
