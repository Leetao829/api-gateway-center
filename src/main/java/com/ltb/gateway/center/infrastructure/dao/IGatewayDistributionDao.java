package com.ltb.gateway.center.infrastructure.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IGatewayDistributionDao {
    List<String> queryDistributionSystemIdList(String gatewayId);

    String queryGatewayDistribution(String systemId);

}
