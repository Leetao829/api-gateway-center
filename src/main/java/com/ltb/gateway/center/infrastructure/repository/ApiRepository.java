package com.ltb.gateway.center.infrastructure.repository;

import com.ltb.gateway.center.domain.model.ApiData;
import com.ltb.gateway.center.domain.repository.IApiRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ApiRepository implements IApiRepository {

    @Override
    public List<ApiData> queryHttpStatementList() {
        return null;
    }
}
