package com.ltb.gateway.center.infrastructure.dao;

import com.ltb.gateway.center.domain.operation.model.vo.GatewayDistributionDataVO;
import com.ltb.gateway.center.infrastructure.common.OperationRequest;
import com.ltb.gateway.center.infrastructure.po.GatewayDistribution;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IGatewayDistributionDao {
    List<String> queryDistributionSystemIdList(String gatewayId);

    String queryGatewayDistribution(String systemId);

    List<GatewayDistribution> queryGatewayDistributionListByPage(OperationRequest<GatewayDistributionDataVO> request);

    int queryGatewayDistributionListCountByPage(OperationRequest<GatewayDistributionDataVO> request);

    List<GatewayDistribution> queryGatewayDistributionList();

}
