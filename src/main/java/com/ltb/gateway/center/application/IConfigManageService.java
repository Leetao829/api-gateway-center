package com.ltb.gateway.center.application;

import com.ltb.gateway.center.domain.manage.model.vo.GatewayServerVO;

import java.util.List;

public interface IConfigManageService {

    List<GatewayServerVO> queryGatewayServerList();

    boolean registerGatewayServerNode(String groupId,String gatewayId,String gatewayName,String gatewayAddress);
}
