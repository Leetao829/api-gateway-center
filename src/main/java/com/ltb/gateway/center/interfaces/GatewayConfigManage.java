package com.ltb.gateway.center.interfaces;

import com.ltb.gateway.center.application.IConfigManageService;
import com.ltb.gateway.center.domain.manage.model.vo.GatewayServerVO;
import com.ltb.gateway.center.infrastructure.common.ResponseCode;
import com.ltb.gateway.center.infrastructure.common.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/wg/admin/config")
public class GatewayConfigManage {

    private final Logger logger = LoggerFactory.getLogger(GatewayConfigManage.class);

    @Resource
    private IConfigManageService configManageService;

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


}
