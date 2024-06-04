package com.ltb.gateway.center.domain.manage.service;

import com.ltb.gateway.center.application.IConfigManageService;
import com.ltb.gateway.center.domain.manage.model.vo.GatewayServerDetailVO;
import com.ltb.gateway.center.domain.manage.model.vo.GatewayServerVO;
import com.ltb.gateway.center.domain.manage.repository.IConfigManageRepository;
import com.ltb.gateway.center.infrastructure.common.Constants;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
}
