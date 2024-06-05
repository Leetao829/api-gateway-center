package com.ltb.gateway.center.infrastructure.dao;

import com.ltb.gateway.center.infrastructure.po.ApplicationSystem;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IApplicationSystemDao {
    void insert(ApplicationSystem applicationSystem);
}
