package com.ltb.gateway.center.domain.operation.repository;

import com.ltb.gateway.center.domain.operation.model.vo.*;
import com.ltb.gateway.center.infrastructure.common.OperationRequest;

import java.util.List;

public interface IDataOperationManageRepository {
    List<GatewayServerDataVO> queryGatewayServerListByPage(OperationRequest<String> request);

    int queryGatewayServerListCountByPage(OperationRequest<String> request);

    List<ApplicationSystemDataVO> queryApplicationSystemListByPage(OperationRequest<ApplicationSystemDataVO> request);

    int queryApplicationSystemListCountByPage(OperationRequest<ApplicationSystemDataVO> request);

    int queryApplicationInterfaceCountByPage(OperationRequest<ApplicationInterfaceDataVO> request);

    List<ApplicationInterfaceDataVO> queryApplicationInterfaceListByPage(OperationRequest<ApplicationInterfaceDataVO> request);

    List<ApplicationInterfaceMethodDataVO> queryApplicationInterfaceMethodListByPage(OperationRequest<ApplicationInterfaceMethodDataVO> request);

    int queryApplicationInterfaceMethodCountByPage(OperationRequest<ApplicationInterfaceMethodDataVO> request);

    List<GatewayServerDetailDataVO> queryGatewayServerDetailListByPage(OperationRequest<GatewayServerDetailDataVO> request);

    int queryGatewayServerDetailCountByPage(OperationRequest<GatewayServerDetailDataVO> request);

    List<GatewayDistributionDataVO> queryGatewayDistributionListByPage(OperationRequest<GatewayDistributionDataVO> request);

    int queryGatewayDistributionCountByPage(OperationRequest<GatewayDistributionDataVO> request);
}
