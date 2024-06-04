package com.ltb.gateway.center.infrastructure.repository;

import com.ltb.gateway.center.domain.manage.model.vo.GatewayServerDetailVO;
import com.ltb.gateway.center.domain.manage.model.vo.GatewayServerVO;
import com.ltb.gateway.center.domain.manage.repository.IConfigManageRepository;
import com.ltb.gateway.center.infrastructure.dao.IGatewayServerDao;
import com.ltb.gateway.center.infrastructure.dao.IGatewayServerDetailDao;
import com.ltb.gateway.center.infrastructure.po.GatewayServer;
import com.ltb.gateway.center.infrastructure.po.GatewayServerDetail;
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
}
