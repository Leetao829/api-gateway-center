package com.ltb.gateway.center.infrastructure.po;

import java.util.Date;

/**
 * 实体对象
 * @author leetao
 */
public class HttpStatement {

    //自增ID
    private Integer id;
    //应用名称
    private String application;
    //服务接口
    private String interfaceName;
    //服务方法
    private String methodName;
    //参数类型
    private String parameterType;
    //网关接口
    private String uri;
    //接口类型
    private String httpCommandType;
    //是否鉴权：true=1 false=0
    private Integer auth;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;

    public void setApplication(String application) {
        this.application = application;
    }

    public void setAuth(Integer auth) {
        this.auth = auth;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setHttpCommandType(String httpCommandType) {
        this.httpCommandType = httpCommandType;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public void setParameterType(String parameterType) {
        this.parameterType = parameterType;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getParameterType() {
        return parameterType;
    }

    public String getUri() {
        return uri;
    }

    public String getMethodName() {
        return methodName;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public String getApplication() {
        return application;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public Integer getAuth() {
        return auth;
    }

    public Integer getId() {
        return id;
    }

    public String getHttpCommandType() {
        return httpCommandType;
    }
}

