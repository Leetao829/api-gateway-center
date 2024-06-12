package com.ltb.gateway.center.infrastructure.dao;

import com.ltb.gateway.center.domain.operation.model.vo.ApplicationInterfaceDataVO;
import com.ltb.gateway.center.infrastructure.common.OperationRequest;
import com.ltb.gateway.center.infrastructure.po.ApplicationInterface;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IApplicationInterfaceDao {
    void insert(ApplicationInterface applicationInterface);

    List<ApplicationInterface> queryApplicationInterfaceList(String systemId);

    int queryApplicationInterfaceCountByPage(OperationRequest<ApplicationInterfaceDataVO> request);

    List<ApplicationInterface> queryApplicationInterfaceListByPage(OperationRequest<ApplicationInterfaceDataVO> request);
}
