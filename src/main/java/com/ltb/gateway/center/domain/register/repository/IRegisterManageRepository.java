package com.ltb.gateway.center.domain.register.repository;

import com.ltb.gateway.center.domain.register.model.vo.ApplicationInterfaceMethodVO;
import com.ltb.gateway.center.domain.register.model.vo.ApplicationInterfaceVO;
import com.ltb.gateway.center.domain.register.model.vo.ApplicationSystemVO;

public interface IRegisterManageRepository {
    void registerApplicationSystem(ApplicationSystemVO applicationSystemVO);

    void registerApplicationInterface(ApplicationInterfaceVO applicationInterfaceVO);

    void registerApplicationInterfaceMethod(ApplicationInterfaceMethodVO applicationInterfaceMethodVO);
}
