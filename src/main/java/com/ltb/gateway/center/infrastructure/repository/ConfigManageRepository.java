package com.ltb.gateway.center.infrastructure.repository;

import com.ltb.gateway.center.domain.manage.model.vo.*;
import com.ltb.gateway.center.domain.manage.repository.IConfigManageRepository;
import com.ltb.gateway.center.infrastructure.dao.*;
import com.ltb.gateway.center.infrastructure.po.*;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ConfigManageRepository implements IConfigManageRepository {

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
    public List<GatewayServerVO> queryGatewayServerList() {
        List<GatewayServer> gatewayServerList = gatewayServerDao.queryGatewayServerList();
        List<GatewayServerVO> result = new ArrayList<>(gatewayServerList.size());
        for(GatewayServer gatewayServer : gatewayServerList){
            GatewayServerVO gatewayServerVO = new GatewayServerVO();
            gatewayServerVO.setGroupId(gatewayServer.getGroupId());
            gatewayServerVO.setGroupName(gatewayServer.getGroupName());
            result.add(gatewayServerVO);
        }
        return result;
    }

    @Override
    public GatewayServerDetailVO queryGatewayServerDetail(String gatewayId, String gatewayAddress) {
        GatewayServerDetail req = new GatewayServerDetail();
        req.setGatewayId(gatewayId);
        req.setGatewayAddress(gatewayAddress);
        GatewayServerDetail gatewayServerDetail = gatewayServerDetailDao.queryGatewayServerDetail(req);
        if(null == gatewayServerDetail) return null;
        GatewayServerDetailVO result = new GatewayServerDetailVO();
        result.setGatewayName(gatewayServerDetail.getGatewayName());
        result.setGatewayId(gatewayServerDetail.getGatewayId());
        result.setGatewayAddress(gatewayServerDetail.getGatewayAddress());
        result.setStatus(gatewayServerDetail.getStatus());
        return result;
    }

    @Override
    public boolean registerGatewayServerNode(String groupId, String gatewayId, String gatewayName, String gatewayAddress, Integer status) {
        GatewayServerDetail gatewayServerDetail = new GatewayServerDetail();
        gatewayServerDetail.setGroupId(groupId);
        gatewayServerDetail.setGatewayId(gatewayId);
        gatewayServerDetail.setGatewayName(gatewayName);
        gatewayServerDetail.setGatewayAddress(gatewayAddress);
        gatewayServerDetail.setStatus(status);
        gatewayServerDetailDao.insert(gatewayServerDetail);
        return true;
    }

    @Override
    public boolean updateGatewayStatus(String gatewayId, String gatewayAddress, Integer status) {
        GatewayServerDetail gatewayServerDetail = new GatewayServerDetail();
        gatewayServerDetail.setStatus(status);
        gatewayServerDetail.setGatewayId(gatewayId);
        gatewayServerDetail.setGatewayAddress(gatewayAddress);
        return gatewayServerDetailDao.updateGatewayStatus(gatewayServerDetail);
    }

    @Override
    public List<String> queryDistributionSystemIdList(String gatewayId) {
        return gatewayDistributionDao.queryDistributionSystemIdList(gatewayId);
    }

    @Override
    public List<ApplicationSystemVO> queryApplicationSystemList(List<String> systemIdList) {
        List<ApplicationSystem> applicationSystemList = applicationSystemDao.queryApplicationSystemList(systemIdList);
        List<ApplicationSystemVO> result = new ArrayList<>(applicationSystemList.size());
        for(ApplicationSystem applicationSystem : applicationSystemList) {
            ApplicationSystemVO applicationSystemVO = new ApplicationSystemVO();
            applicationSystemVO.setSystemId(applicationSystem.getSystemId());
            applicationSystemVO.setSystemName(applicationSystem.getSystemName());
            applicationSystemVO.setSystemType(applicationSystem.getSystemType());
            applicationSystemVO.setSystemRegistry(applicationSystem.getSystemRegistry());
            result.add(applicationSystemVO);
        }
        return result;
    }

    @Override
    public List<ApplicationInterfaceVO> queryApplicationInterfaceList(String systemId) {
        List<ApplicationInterface> applicationInterfaceList = applicationInterfaceDao.queryApplicationInterfaceList(systemId);
        List<ApplicationInterfaceVO> result = new ArrayList<>(applicationInterfaceList.size());
        for(ApplicationInterface applicationInterface : applicationInterfaceList) {
            ApplicationInterfaceVO applicationInterfaceVO = new ApplicationInterfaceVO();
            applicationInterfaceVO.setInterfaceId(applicationInterface.getInterfaceId());
            applicationInterfaceVO.setInterfaceName(applicationInterface.getInterfaceName());
            applicationInterfaceVO.setSystemId(applicationInterface.getSystemId());
            applicationInterfaceVO.setInterfaceVersion(applicationInterface.getInterfaceVersion());
            result.add(applicationInterfaceVO);
        }
        return result;
    }

    @Override
    public List<ApplicationInterfaceMethodVO> queryApplicationInterfaceMethodList(String systemId,String interfaceId) {
        ApplicationInterfaceMethod req = new ApplicationInterfaceMethod();
        req.setSystemId(systemId);
        req.setInterfaceId(interfaceId);
        List<ApplicationInterfaceMethod> applicationInterfaceMethods = applicationInterfaceMethodDao.queryApplicationInterfaceMethodList(req);
        List<ApplicationInterfaceMethodVO> result = new ArrayList<>(applicationInterfaceMethods.size());
        for(ApplicationInterfaceMethod applicationInterfaceMethod : applicationInterfaceMethods) {
            ApplicationInterfaceMethodVO applicationInterfaceMethodVO = new ApplicationInterfaceMethodVO();
            applicationInterfaceMethodVO.setSystemId(applicationInterfaceMethod.getSystemId());
            applicationInterfaceMethodVO.setInterfaceId(applicationInterfaceMethod.getInterfaceId());
            applicationInterfaceMethodVO.setMethodId(applicationInterfaceMethod.getMethodId());
            applicationInterfaceMethodVO.setMethodName(applicationInterfaceMethod.getMethodName());
            applicationInterfaceMethodVO.setParameterType(applicationInterfaceMethod.getParameterType());
            applicationInterfaceMethodVO.setUri(applicationInterfaceMethod.getUri());
            applicationInterfaceMethodVO.setHttpCommandType(applicationInterfaceMethod.getHttpCommandType());
            applicationInterfaceMethodVO.setAuth(applicationInterfaceMethod.getAuth());
            result.add(applicationInterfaceMethodVO);
        }
        return result;
    }

    @Override
    public String queryGatewayDistribution(String systemId) {
        return gatewayDistributionDao.queryGatewayDistribution(systemId);
    }

    @Override
    public List<GatewayServerDetailVO> queryGatewayServerDetailList() {
        List<GatewayServerDetail> gatewayServerDetails = gatewayServerDetailDao.queryGatewayServerDetailList();
        List<GatewayServerDetailVO> gatewayServerDetailVOList = new ArrayList<>(gatewayServerDetails.size());
        for (GatewayServerDetail gatewayServerDetail : gatewayServerDetails) {
            GatewayServerDetailVO gatewayServerDetailVO = new GatewayServerDetailVO();
            gatewayServerDetailVO.setId(gatewayServerDetail.getId());
            gatewayServerDetailVO.setGroupId(gatewayServerDetail.getGroupId());
            gatewayServerDetailVO.setGatewayId(gatewayServerDetail.getGatewayId());
            gatewayServerDetailVO.setGatewayName(gatewayServerDetail.getGatewayName());
            gatewayServerDetailVO.setGatewayAddress(gatewayServerDetail.getGatewayAddress());
            gatewayServerDetailVO.setStatus(gatewayServerDetail.getStatus());
            gatewayServerDetailVO.setCreateTime(gatewayServerDetail.getCreateTime());
            gatewayServerDetailVO.setUpdateTime(gatewayServerDetail.getUpdateTime());
            gatewayServerDetailVOList.add(gatewayServerDetailVO);
        }
        return gatewayServerDetailVOList;

    }

    @Override
    public List<GatewayDistributionVO> queryGatewayDistributionList() {
        List<GatewayDistribution> gatewayDistributions = gatewayDistributionDao.queryGatewayDistributionList();
        List<GatewayDistributionVO> gatewayDistributionVOList = new ArrayList<>(gatewayDistributions.size());
        for (GatewayDistribution gatewayDistribution: gatewayDistributions){
            GatewayDistributionVO gatewayDistributionVO = new GatewayDistributionVO();
            gatewayDistributionVO.setId(gatewayDistribution.getId());
            gatewayDistributionVO.setGroupId(gatewayDistribution.getGroupId());
            gatewayDistributionVO.setGatewayId(gatewayDistribution.getGatewayId());
            gatewayDistributionVO.setSystemId(gatewayDistribution.getSystemId());
            gatewayDistributionVO.setSystemName(gatewayDistribution.getSystemName());
            gatewayDistributionVO.setCreateTime(gatewayDistribution.getCreateTime());
            gatewayDistributionVO.setUpdateTime(gatewayDistribution.getUpdateTime());
            gatewayDistributionVOList.add(gatewayDistributionVO);
        }
        return gatewayDistributionVOList;

    }
}
