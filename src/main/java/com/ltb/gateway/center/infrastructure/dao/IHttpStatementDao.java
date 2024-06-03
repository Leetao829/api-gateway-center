package com.ltb.gateway.center.infrastructure.dao;


import com.ltb.gateway.center.infrastructure.po.HttpStatement;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IHttpStatementDao {
    List<HttpStatement> queryHttpStatementList();
}
