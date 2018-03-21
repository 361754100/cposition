package com.hro.core.cposition.controller;

import com.hro.core.cposition.controller.request.PositionReq;
import com.hro.core.cposition.controller.response.CommonResp;
import com.hro.core.cposition.controller.response.PositionQueryPageResp;
import com.hro.core.cposition.dao.model.Position;
import com.hro.core.cposition.log.LogUtil;
import com.hro.core.cposition.service.PositionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/position")
@Api(value = "position")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @ApiOperation(value = "添加/更新位置信息", notes = "")
    @RequestMapping(value = "/saveOrUpdateInfo", method = RequestMethod.POST)
    @ResponseBody
    public CommonResp saveOrUpdateInfo(@RequestBody PositionReq req) {
        LogUtil.info("添加/更新位置信息, 接收到的请求参数={}", req);

        CommonResp resp = positionService.saveOrUpdateInfo(req);
        LogUtil.info("添加/更新位置信息，响应消息={}", resp);
        return resp;
    }

    @ApiOperation(value = "删除位置信息", notes = "")
    @RequestMapping(value = "/delInfo", method = RequestMethod.POST)
    @ResponseBody
    public CommonResp delInfo(@RequestBody PositionReq req) {
        LogUtil.info("删除位置信息, 接收到的请求参数={}", req);

        CommonResp resp = positionService.delInfo(req);
        LogUtil.info("删除位置信息，响应消息={}", resp);
        return resp;
    }

    @ApiOperation(value = "分页查询位置信息", notes = "")
    @RequestMapping(value = "/queryInfoPage", method = RequestMethod.POST)
    @ResponseBody
    public PositionQueryPageResp queryInfoPage(@RequestBody PositionReq req) {
        LogUtil.info("分页查询位置信息, 接收到的请求参数={}", req);

        PositionQueryPageResp resp = positionService.queryInfoPage(req);
        LogUtil.info("分页查询位置信息，响应消息={}", resp);
        return resp;
    }

    @ApiOperation(value = "根据设备编号查询位置信息", notes = "")
    @RequestMapping(value = "/queryInfoByDevid", method = RequestMethod.POST)
    @ResponseBody
    public Position queryInfoByDevid(@RequestBody Position params) {
        LogUtil.info("根据设备编号查询位置信息, 接收到的请求参数={}", params);

        String devid = params.getDevid();
        Position resp = positionService.queryInfoByDevid(devid);
        LogUtil.info("根据设备编号查询位置信息，响应消息={}", resp);
        return resp;
    }

}
