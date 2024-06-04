package com.ltb.gateway.center.domain.manage.repository;

import com.ltb.gateway.center.domain.manage.model.vo.GatewayServerDetailVO;
import com.ltb.gateway.center.domain.manage.model.vo.GatewayServerVO;

import java.util.List;

public interface IConfigManageRepository {
    List<GatewayServerVO> queryGatewayServerList();

    GatewayServerDetailVO queryGatewayServerDetail(String gatewayId, String gatewayAddress);

    boolean registerGatewayServerNode(String groupId, String gatewayId, String gatewayName, String gatewayAddress, Integer available);

    boolean updateGatewayStatus(String gatewayId, String gatewayAddress, Integer available);
}
