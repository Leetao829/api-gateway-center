package com.ltb.gateway.center.application;

import com.ltb.gateway.center.domain.operation.model.vo.*;
import com.ltb.gateway.center.infrastructure.common.OperationRequest;
import com.ltb.gateway.center.infrastructure.common.OperationResult;

/**
 * 网关运营数据管理
 *
 * @author leetao
 */
public interface IDataOperationManageService {

    OperationResult<GatewayServerDataVO> queryGatewayServer(OperationRequest<String> request);

    OperationResult<ApplicationSystemDataVO> queryApplicationSystem(OperationRequest<ApplicationSystemDataVO> request);

    OperationResult<ApplicationInterfaceDataVO> queryApplicationInterface(OperationRequest<ApplicationInterfaceDataVO> request);

    OperationResult<ApplicationInterfaceMethodDataVO> queryApplicationInterfaceMethod(OperationRequest<ApplicationInterfaceMethodDataVO> request);

    OperationResult<GatewayServerDetailDataVO> queryGatewayServerDetail(OperationRequest<GatewayServerDetailDataVO> request);

    OperationResult<GatewayDistributionDataVO> queryGatewayDistribution(OperationRequest<GatewayDistributionDataVO> request);

}
