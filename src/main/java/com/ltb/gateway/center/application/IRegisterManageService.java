package com.ltb.gateway.center.application;

import com.ltb.gateway.center.domain.register.model.vo.ApplicationInterfaceMethodVO;
import com.ltb.gateway.center.domain.register.model.vo.ApplicationInterfaceVO;
import com.ltb.gateway.center.domain.register.model.vo.ApplicationSystemVO;

/**
 * 接口注册服务
 *
 * @author leetao
 */
public interface IRegisterManageService {

    void registerApplicationSystem(ApplicationSystemVO applicationSystemVO);

    void registerApplicationInterface(ApplicationInterfaceVO applicationInterfaceVO);

    void registerApplicationInterfaceMethod(ApplicationInterfaceMethodVO applicationInterfaceMethodVO);
}
