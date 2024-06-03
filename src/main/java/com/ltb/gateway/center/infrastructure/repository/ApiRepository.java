package com.ltb.gateway.center.infrastructure.repository;

import com.ltb.gateway.center.domain.model.ApiData;
import com.ltb.gateway.center.domain.repository.IApiRepository;
import com.ltb.gateway.center.infrastructure.dao.IHttpStatementDao;
import com.ltb.gateway.center.infrastructure.po.HttpStatement;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ApiRepository implements IApiRepository {

    @Resource
    private IHttpStatementDao httpStatementDao;

    @Override
    public List<ApiData> queryHttpStatementList() {
        List<HttpStatement> httpStatements = httpStatementDao.queryHttpStatementList();
        List<ApiData> result = new ArrayList<>(httpStatements.size());
        for(HttpStatement httpStatement : httpStatements){
            ApiData apiData = new ApiData();
            apiData.setApplication(httpStatement.getApplication());
            apiData.setInterfaceName(httpStatement.getInterfaceName());
            apiData.setMethodName(httpStatement.getMethodName());
            apiData.setUri(httpStatement.getUri());
            apiData.setParameterType(httpStatement.getParameterType());
            apiData.setHttpCommandType(httpStatement.getHttpCommandType());
            apiData.setAuth(httpStatement.getAuth());
            result.add(apiData);
        }
        return result;
    }
}
