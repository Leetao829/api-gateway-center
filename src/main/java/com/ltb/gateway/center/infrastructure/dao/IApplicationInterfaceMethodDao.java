package com.ltb.gateway.center.infrastructure.dao;

import com.ltb.gateway.center.infrastructure.po.ApplicationInterfaceMethod;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IApplicationInterfaceMethodDao {
    void insert(ApplicationInterfaceMethod applicationInterfaceMethod);
}
