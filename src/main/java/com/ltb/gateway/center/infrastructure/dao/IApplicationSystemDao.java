package com.ltb.gateway.center.infrastructure.dao;

import com.ltb.gateway.center.domain.operation.model.vo.ApplicationSystemDataVO;
import com.ltb.gateway.center.infrastructure.common.OperationRequest;
import com.ltb.gateway.center.infrastructure.po.ApplicationSystem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IApplicationSystemDao {
    void insert(ApplicationSystem applicationSystem);

    List<ApplicationSystem> queryApplicationSystemList(List<String> systemIdList);

    List<ApplicationSystem> queryApplicationSystemListByPage(OperationRequest<ApplicationSystemDataVO> request);

    int queryApplicationSystemListCountByPage(OperationRequest<ApplicationSystemDataVO> request);
}
