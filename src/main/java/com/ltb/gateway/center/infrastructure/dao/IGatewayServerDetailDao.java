package com.ltb.gateway.center.infrastructure.dao;


import com.ltb.gateway.center.domain.operation.model.vo.GatewayServerDetailDataVO;
import com.ltb.gateway.center.infrastructure.common.OperationRequest;
import com.ltb.gateway.center.infrastructure.po.GatewayServerDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IGatewayServerDetailDao {
    GatewayServerDetail queryGatewayServerDetail(GatewayServerDetail req);

    void insert(GatewayServerDetail gatewayServerDetail);

    boolean updateGatewayStatus(GatewayServerDetail gatewayServerDetail);

    List<GatewayServerDetail> queryGatewayServerDetailListByPage(OperationRequest<GatewayServerDetailDataVO> request);

    int queryGatewayServerDetailCountByPage(OperationRequest<GatewayServerDetailDataVO> request);

    List<GatewayServerDetail> queryGatewayServerDetailList();
}
