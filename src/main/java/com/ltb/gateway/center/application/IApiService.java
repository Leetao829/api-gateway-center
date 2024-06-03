package com.ltb.gateway.center.application;

import com.ltb.gateway.center.domain.model.ApiData;

import java.util.List;

public interface IApiService {
    List<ApiData> queryHttpStatementList();
}
