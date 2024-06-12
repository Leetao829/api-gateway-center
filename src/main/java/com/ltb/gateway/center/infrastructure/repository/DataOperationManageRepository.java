package com.ltb.gateway.center.infrastructure.repository;

import com.ltb.gateway.center.domain.operation.model.vo.*;
import com.ltb.gateway.center.domain.operation.repository.IDataOperationManageRepository;
import com.ltb.gateway.center.infrastructure.common.OperationRequest;
import com.ltb.gateway.center.infrastructure.dao.*;
import com.ltb.gateway.center.infrastructure.po.*;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DataOperationManageRepository implements IDataOperationManageRepository {

    @Resource
    private IGatewayServerDao gatewayServerDao;

    @Resource
    private IGatewayServerDetailDao gatewayServerDetailDao;

    @Resource
    private IGatewayDistributionDao gatewayDistributionDao;

    @Resource
    private IApplicationSystemDao applicationSystemDao;

    @Resource
    private IApplicationInterfaceDao applicationInterfaceDao;

    @Resource
    private IApplicationInterfaceMethodDao applicationInterfaceMethodDao;

    @Override
    public List<GatewayServerDataVO> queryGatewayServerListByPage(OperationRequest<String> request) {
        List<GatewayServer> gatewayServers = gatewayServerDao.queryGatewayServerListByPage(request);
        List<GatewayServerDataVO> gatewayServerVOList = new ArrayList<>(gatewayServers.size());
        for (GatewayServer gatewayServer : gatewayServers) {
            // 可以按照 IDEA 插件 vo2dto 方便转换
            GatewayServerDataVO gatewayServerVO = new GatewayServerDataVO();
            gatewayServerVO.setId(gatewayServer.getId());
            gatewayServerVO.setGroupId(gatewayServer.getGroupId());
            gatewayServerVO.setGroupName(gatewayServer.getGroupName());
            gatewayServerVOList.add(gatewayServerVO);
        }
        return gatewayServerVOList;

    }

    @Override
    public int queryGatewayServerListCountByPage(OperationRequest<String> request) {
        return gatewayServerDao.queryGatewayServerListCountByPage(request);
    }

    @Override
    public List<ApplicationSystemDataVO> queryApplicationSystemListByPage(OperationRequest<ApplicationSystemDataVO> request) {
        List<ApplicationSystem> applicationSystems = applicationSystemDao.queryApplicationSystemListByPage(request);
        List<ApplicationSystemDataVO> applicationSystemDataVOList = new ArrayList<>(applicationSystems.size());
        for (ApplicationSystem applicationSystem : applicationSystems) {
            ApplicationSystemDataVO applicationSystemDataVO = new ApplicationSystemDataVO();
            applicationSystemDataVO.setSystemId(applicationSystem.getSystemId());
            applicationSystemDataVO.setSystemName(applicationSystem.getSystemName());
            applicationSystemDataVO.setSystemType(applicationSystem.getSystemType());
            applicationSystemDataVO.setSystemRegistry(applicationSystem.getSystemRegistry());
            applicationSystemDataVOList.add(applicationSystemDataVO);
        }
        return applicationSystemDataVOList;

    }

    @Override
    public int queryApplicationSystemListCountByPage(OperationRequest<ApplicationSystemDataVO> request) {
        return applicationSystemDao.queryApplicationSystemListCountByPage(request);
    }

    @Override
    public int queryApplicationInterfaceCountByPage(OperationRequest<ApplicationInterfaceDataVO> request) {
        return applicationInterfaceDao.queryApplicationInterfaceCountByPage(request);
    }

    @Override
    public List<ApplicationInterfaceDataVO> queryApplicationInterfaceListByPage(OperationRequest<ApplicationInterfaceDataVO> request) {
        List<ApplicationInterface> applicationInterfaces = applicationInterfaceDao.queryApplicationInterfaceListByPage(request);
        List<ApplicationInterfaceDataVO> applicationInterfaceDataVOList = new ArrayList<>(applicationInterfaces.size());
        for (ApplicationInterface applicationInterface : applicationInterfaces) {
            ApplicationInterfaceDataVO applicationInterfaceDataVO = new ApplicationInterfaceDataVO();
            applicationInterfaceDataVO.setSystemId(applicationInterface.getSystemId());
            applicationInterfaceDataVO.setInterfaceId(applicationInterface.getInterfaceId());
            applicationInterfaceDataVO.setInterfaceName(applicationInterface.getInterfaceName());
            applicationInterfaceDataVO.setInterfaceVersion(applicationInterface.getInterfaceVersion());
            applicationInterfaceDataVOList.add(applicationInterfaceDataVO);
        }
        return applicationInterfaceDataVOList;

    }

    @Override
    public List<ApplicationInterfaceMethodDataVO> queryApplicationInterfaceMethodListByPage(OperationRequest<ApplicationInterfaceMethodDataVO> request) {
        List<ApplicationInterfaceMethod> applicationInterfaceMethods = applicationInterfaceMethodDao.queryApplicationInterfaceMethodListByPage(request);
        List<ApplicationInterfaceMethodDataVO> applicationInterfaceMethodDataVOList = new ArrayList<>(applicationInterfaceMethods.size());
        for (ApplicationInterfaceMethod applicationInterfaceMethod : applicationInterfaceMethods) {
            ApplicationInterfaceMethodDataVO applicationInterfaceMethodDataVO = new ApplicationInterfaceMethodDataVO();
            applicationInterfaceMethodDataVO.setSystemId(applicationInterfaceMethod.getSystemId());
            applicationInterfaceMethodDataVO.setInterfaceId(applicationInterfaceMethod.getInterfaceId());
            applicationInterfaceMethodDataVO.setMethodId(applicationInterfaceMethod.getMethodId());
            applicationInterfaceMethodDataVO.setMethodName(applicationInterfaceMethod.getMethodName());
            applicationInterfaceMethodDataVO.setParameterType(applicationInterfaceMethod.getParameterType());
            applicationInterfaceMethodDataVO.setUri(applicationInterfaceMethod.getUri());
            applicationInterfaceMethodDataVO.setHttpCommandType(applicationInterfaceMethod.getHttpCommandType());
            applicationInterfaceMethodDataVO.setAuth(applicationInterfaceMethod.getAuth());
            applicationInterfaceMethodDataVOList.add(applicationInterfaceMethodDataVO);
        }
        return applicationInterfaceMethodDataVOList;

    }

    @Override
    public int queryApplicationInterfaceMethodCountByPage(OperationRequest<ApplicationInterfaceMethodDataVO> request) {
        return applicationInterfaceMethodDao.queryApplicationInterfaceMethodListCountByPage(request);
    }

    @Override
    public List<GatewayServerDetailDataVO> queryGatewayServerDetailListByPage(OperationRequest<GatewayServerDetailDataVO> request) {
        List<GatewayServerDetail> applicationInterfaceMethods = gatewayServerDetailDao.queryGatewayServerDetailListByPage(request);
        List<GatewayServerDetailDataVO> gatewayServerDetailDataVOList = new ArrayList<>(applicationInterfaceMethods.size());
        for (GatewayServerDetail gatewayServerDetail : applicationInterfaceMethods) {
            GatewayServerDetailDataVO gatewayServerDetailDataVO = new GatewayServerDetailDataVO();
            gatewayServerDetailDataVO.setId(gatewayServerDetail.getId());
            gatewayServerDetailDataVO.setGroupId(gatewayServerDetail.getGroupId());
            gatewayServerDetailDataVO.setGatewayId(gatewayServerDetail.getGatewayId());
            gatewayServerDetailDataVO.setGatewayName(gatewayServerDetail.getGatewayName());
            gatewayServerDetailDataVO.setGatewayAddress(gatewayServerDetail.getGatewayAddress());
            gatewayServerDetailDataVO.setStatus(gatewayServerDetail.getStatus());
            gatewayServerDetailDataVO.setCreateTime(gatewayServerDetail.getCreateTime());
            gatewayServerDetailDataVO.setUpdateTime(gatewayServerDetail.getUpdateTime());
            gatewayServerDetailDataVOList.add(gatewayServerDetailDataVO);
        }
        return gatewayServerDetailDataVOList;

    }

    @Override
    public int queryGatewayServerDetailCountByPage(OperationRequest<GatewayServerDetailDataVO> request) {
        return gatewayServerDetailDao.queryGatewayServerDetailCountByPage(request);
    }

    @Override
    public List<GatewayDistributionDataVO> queryGatewayDistributionListByPage(OperationRequest<GatewayDistributionDataVO> request) {
        List<GatewayDistribution> gatewayDistributions = gatewayDistributionDao.queryGatewayDistributionListByPage(request);
        List<GatewayDistributionDataVO> gatewayServerDetailDataVOList = new ArrayList<>(gatewayDistributions.size());
        for (GatewayDistribution gatewayDistribution : gatewayDistributions) {
            GatewayDistributionDataVO gatewayDistributionDataVO = new GatewayDistributionDataVO();
            gatewayDistributionDataVO.setId(gatewayDistribution.getId());
            gatewayDistributionDataVO.setGroupId(gatewayDistribution.getGroupId());
            gatewayDistributionDataVO.setGatewayId(gatewayDistribution.getGatewayId());
            gatewayDistributionDataVO.setSystemId(gatewayDistribution.getSystemId());
            gatewayDistributionDataVO.setSystemName(gatewayDistribution.getSystemName());
            gatewayDistributionDataVO.setCreateTime(gatewayDistribution.getCreateTime());
            gatewayDistributionDataVO.setUpdateTime(gatewayDistribution.getUpdateTime());
            gatewayServerDetailDataVOList.add(gatewayDistributionDataVO);
        }
        return gatewayServerDetailDataVOList;

    }

    @Override
    public int queryGatewayDistributionCountByPage(OperationRequest<GatewayDistributionDataVO> request) {
        return gatewayDistributionDao.queryGatewayDistributionListCountByPage(request);
    }
}
