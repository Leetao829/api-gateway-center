package com.ltb.gateway.center.domain.register.service;

import com.ltb.gateway.center.application.IRegisterManageService;
import com.ltb.gateway.center.domain.register.model.vo.ApplicationInterfaceMethodVO;
import com.ltb.gateway.center.domain.register.model.vo.ApplicationInterfaceVO;
import com.ltb.gateway.center.domain.register.model.vo.ApplicationSystemVO;
import com.ltb.gateway.center.domain.register.repository.IRegisterManageRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RegisterManageService implements IRegisterManageService {

    @Resource
    private IRegisterManageRepository registerManageRepository;

    @Override
    public void registerApplicationSystem(ApplicationSystemVO applicationSystemVO) {
        registerManageRepository.registerApplicationSystem(applicationSystemVO);
    }

    @Override
    public void registerApplicationInterface(ApplicationInterfaceVO applicationInterfaceVO) {
        registerManageRepository.registerApplicationInterface(applicationInterfaceVO);
    }

    @Override
    public void registerApplicationInterfaceMethod(ApplicationInterfaceMethodVO applicationInterfaceMethodVO) {
        registerManageRepository.registerApplicationInterfaceMethod(applicationInterfaceMethodVO);
    }
}
