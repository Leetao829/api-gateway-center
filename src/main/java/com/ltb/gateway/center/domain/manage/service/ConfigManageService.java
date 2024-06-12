package com.ltb.gateway.center.domain.manage.service;

import com.ltb.gateway.center.application.IConfigManageService;
import com.ltb.gateway.center.domain.manage.model.aggregates.ApplicationSystemRichInfo;
import com.ltb.gateway.center.domain.manage.model.vo.*;
import com.ltb.gateway.center.domain.manage.repository.IConfigManageRepository;
import com.ltb.gateway.center.infrastructure.common.Constants;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 网关配置服务
 *
 * @author leetao
 */
@Service
public class ConfigManageService implements IConfigManageService {

    @Resource
    private IConfigManageRepository configManageRepository;


    @Override
    public List<GatewayServerVO> queryGatewayServerList() {
        return configManageRepository.queryGatewayServerList();
    }

    @Override
    public List<GatewayServerDetailVO> queryGatewayServerDetailList() {
        return configManageRepository.queryGatewayServerDetailList();
    }

    @Override
    public List<GatewayDistributionVO> queryGatewayDistributionList() {
        return configManageRepository.queryGatewayDistributionList();
    }


    @Override
    public boolean registerGatewayServerNode(String groupId, String gatewayId, String gatewayName, String gatewayAddress) {
        GatewayServerDetailVO gatewayServerDetailVO = configManageRepository.queryGatewayServerDetail(gatewayId, gatewayAddress);
        if(null == gatewayServerDetailVO){
            try {
                return configManageRepository.registerGatewayServerNode(groupId,gatewayId,gatewayName,gatewayAddress, Constants.GatewayStatus.Available);
            } catch (DuplicateKeyException e) {
                return configManageRepository.updateGatewayStatus(gatewayId,gatewayAddress,Constants.GatewayStatus.Available);
            }
        }else {
            return configManageRepository.updateGatewayStatus(gatewayId,gatewayAddress,Constants.GatewayStatus.Available);
        }
    }

    @Override
    public ApplicationSystemRichInfo queryApplicationSystemRichInfo(String gatewayId, String systemId) {
        List<String> systemIdList = new ArrayList<>();
        if(null == systemId) {
            systemIdList = configManageRepository.queryDistributionSystemIdList(gatewayId);
        }else {
            systemIdList.add(systemId);
        }
        //根据systemIdList查询系统列表信息
        List<ApplicationSystemVO> applicationSystemVOList = configManageRepository.queryApplicationSystemList(systemIdList);
        //查询每一个系统找到接口和方法
        for (ApplicationSystemVO applicationSystemVO : applicationSystemVOList) {
            //查询每一个系统的接口列表
            List<ApplicationInterfaceVO> applicationInterfaceVOList = configManageRepository.queryApplicationInterfaceList(applicationSystemVO.getSystemId());
            for (ApplicationInterfaceVO applicationInterfaceVO : applicationInterfaceVOList) {
                //每一个接口的方法列表
                List<ApplicationInterfaceMethodVO> applicationInterfaceMethodVOList = configManageRepository.queryApplicationInterfaceMethodList(applicationSystemVO.getSystemId(), applicationInterfaceVO.getInterfaceId());
                applicationInterfaceVO.setMethodList(applicationInterfaceMethodVOList);
            }
            applicationSystemVO.setInterfaceList(applicationInterfaceVOList);
        }
        return new ApplicationSystemRichInfo(gatewayId, applicationSystemVOList);
    }

    @Override
    public String queryGatewayDistribution(String systemId) {
        return configManageRepository.queryGatewayDistribution(systemId);
    }

    @Override
    public List<ApplicationSystemVO> queryApplicationSystemList() {
        return configManageRepository.queryApplicationSystemList(null);
    }

    @Override
    public List<ApplicationInterfaceVO> queryApplicationInterfaceList() {
        return configManageRepository.queryApplicationInterfaceList(null);
    }

    @Override
    public List<ApplicationInterfaceMethodVO> queryApplicationInterfaceMethodList() {
        return configManageRepository.queryApplicationInterfaceMethodList(null, null);
    }

}
