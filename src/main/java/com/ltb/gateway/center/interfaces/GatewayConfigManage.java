package com.ltb.gateway.center.interfaces;

import com.ltb.gateway.center.application.IConfigManageService;
import com.ltb.gateway.center.application.IMessageService;
import com.ltb.gateway.center.domain.manage.model.aggregates.ApplicationSystemRichInfo;
import com.ltb.gateway.center.domain.manage.model.vo.*;
import com.ltb.gateway.center.infrastructure.common.ResponseCode;
import com.ltb.gateway.center.infrastructure.common.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/wg/admin/config")
public class GatewayConfigManage {

    private final Logger logger = LoggerFactory.getLogger(GatewayConfigManage.class);

    @Resource
    private IConfigManageService configManageService;

    @Resource
    private IMessageService messageService;

    @GetMapping(value = "queryServerConfig")
    public Result<List<GatewayServerVO>> queryServerConfig(){
        try {
            logger.info("查询网关服务配置信息");
            List<GatewayServerVO> gatewayServerVOList = configManageService.queryGatewayServerList();
            return new Result<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getInfo(), gatewayServerVOList);
        } catch (Exception e) {
            logger.info("查询网关服务配置信息异常");
            return new Result<>(ResponseCode.UN_ERROR.getCode(), e.getMessage(),null);
        }
    }

    @GetMapping(value = "queryServerDetailConfig")
    public Result<List<GatewayServerDetailVO>> queryServerDetailConfig(){
        try {
            logger.info("查询网关算力节点配置项信息");
            List<GatewayServerDetailVO> gatewayServerVOList = configManageService.queryGatewayServerDetailList();
            return new Result<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getInfo(), gatewayServerVOList);
        } catch (Exception e) {
            logger.error("查询网关算力节点配置项信息异常", e);
            return new Result<>(ResponseCode.UN_ERROR.getCode(), e.getMessage(), null);
        }
    }

    @GetMapping(value = "queryGatewayDistributionList")
    public Result<List<GatewayDistributionVO>> queryGatewayDistributionList(){
        try {
            logger.info("查询网关分配配置项信息");
            List<GatewayDistributionVO> gatewayServerVOList = configManageService.queryGatewayDistributionList();
            return new Result<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getInfo(), gatewayServerVOList);
        } catch (Exception e) {
            logger.error("查询网关分配配置项信息异常", e);
            return new Result<>(ResponseCode.UN_ERROR.getCode(), e.getMessage(), null);
        }
    }



    @PostMapping(value = "registerGateway")
    public Result<Boolean> registerGatewayServerNode(@RequestParam String groupId,@RequestParam String gatewayId,@RequestParam String gatewayName,@RequestParam String gatewayAddress){
        try {
            logger.info("注册网关服务节点 gatewayId:{},gatewayAddress:{},gatewayName:{}",gatewayId,gatewayAddress,gatewayName);
            boolean res = configManageService.registerGatewayServerNode(groupId, gatewayId, gatewayName, gatewayAddress);
            return new Result<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getInfo(), res);
        } catch (Exception e) {
            logger.info("注册网关节点失败");
            return new Result<>(ResponseCode.UN_ERROR.getCode(), ResponseCode.UN_ERROR.getInfo(), false);
        }
    }

    @PostMapping(value = "queryApplicationSystemList")
    public Result<List<ApplicationSystemVO>> queryApplicationSystemList(){
        try {
            logger.info("查询应用服务配置项信息");
            List<ApplicationSystemVO> gatewayServerVOList = configManageService.queryApplicationSystemList();
            return new Result<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getInfo(), gatewayServerVOList);
        } catch (Exception e) {
            logger.error("查询应用服务配置项信息异常", e);
            return new Result<>(ResponseCode.UN_ERROR.getCode(), e.getMessage(), null);
        }
    }

    @PostMapping(value = "queryApplicationInterfaceList")
    public Result<List<ApplicationInterfaceVO>> queryApplicationInterfaceList(){
        try {
            logger.info("查询应用接口配置项信息");
            List<ApplicationInterfaceVO> gatewayServerVOList = configManageService.queryApplicationInterfaceList();
            return new Result<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getInfo(), gatewayServerVOList);
        } catch (Exception e) {
            logger.error("查询应用接口配置项信息异常", e);
            return new Result<>(ResponseCode.UN_ERROR.getCode(), e.getMessage(), null);
        }
    }

    @PostMapping(value = "queryApplicationInterfaceMethodList")
    public Result<List<ApplicationInterfaceMethodVO>> queryApplicationInterfaceMethodList(){
        try {
            logger.info("查询应用接口方法配置项信息");
            List<ApplicationInterfaceMethodVO> gatewayServerVOList = configManageService.queryApplicationInterfaceMethodList();
            return new Result<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getInfo(), gatewayServerVOList);
        } catch (Exception e) {
            logger.error("查询应用接口方法配置项信息异常", e);
            return new Result<>(ResponseCode.UN_ERROR.getCode(), e.getMessage(), null);
        }
    }


    @PostMapping(value = "queryApplicationSystemRichInfo")
    public Result<ApplicationSystemRichInfo> queryApplicationSystemRichInfo(@RequestParam String gatewayId,
                                                                            @RequestParam String systemId) {
        try {
            logger.info("查询分配到网关下的待注册系统信息(系统、接口、方法) gatewayId：{}", gatewayId);
            ApplicationSystemRichInfo applicationSystemRichInfo = configManageService.queryApplicationSystemRichInfo(gatewayId,systemId);
            return new Result<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getInfo(), applicationSystemRichInfo);
        } catch (Exception e) {
            logger.error("查询分配到网关下的待注册系统信息(系统、接口、方法)异常 gatewayId：{}", gatewayId, e);
            return new Result<>(ResponseCode.UN_ERROR.getCode(), e.getMessage(), null);
        }
    }

    @PostMapping(value = "queryRedisConfig")
    public Result<Map<String,String>> queryRedisConfig() {
        try {
            logger.info("查询配置中心Redis配置信息");
            Map<String, String> redisConfig = messageService.queryRedisConfig();
            return new Result<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getInfo(), redisConfig);
        } catch (Exception e) {
            logger.error("查询配置中心Redis配置信息失败", e);
            return new Result<>(ResponseCode.UN_ERROR.getCode(), e.getMessage(), null);
        }
    }




}
