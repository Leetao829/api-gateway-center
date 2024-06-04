package com.ltb.gateway.center.domain.manage.model.vo;

/**
 * 网关服务配置
 *
 * @author leetao
 */
public class GatewayServerVO {
    //分组id
    private String groupId;
    //分组名称
    private String groupName;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
