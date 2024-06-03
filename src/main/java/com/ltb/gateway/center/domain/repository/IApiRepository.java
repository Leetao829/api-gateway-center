package com.ltb.gateway.center.domain.repository;

import com.ltb.gateway.center.domain.model.ApiData;

import java.util.List;

public interface IApiRepository {
    List<ApiData> queryHttpStatementList();
}
