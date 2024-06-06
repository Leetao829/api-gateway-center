package com.ltb.gateway.center.domain.manage.model.aggregates;

import com.ltb.gateway.center.domain.manage.model.vo.ApplicationSystemVO;

import java.util.List;

/**
 * 网关算力配置信息
 * @author leetao
 */
public class ApplicationSystemRichInfo {
    //网关id
    private String gatewayId;
    //系统列表:一个网关可以挂上多个系统
    private List<ApplicationSystemVO> applicationSystemVOList;

    public ApplicationSystemRichInfo(String gatewayId,List<ApplicationSystemVO> applicationSystemVOList) {
        this.gatewayId = gatewayId;
        this.applicationSystemVOList = applicationSystemVOList;
    }

    public String getGatewayId() {
        return gatewayId;
    }

    public void setGatewayId(String gatewayId) {
        this.gatewayId = gatewayId;
    }

    public List<ApplicationSystemVO> getApplicationSystemVOList() {
        return applicationSystemVOList;
    }

    public void setApplicationSystemVOList(List<ApplicationSystemVO> applicationSystemVOList) {
        this.applicationSystemVOList = applicationSystemVOList;
    }
}
