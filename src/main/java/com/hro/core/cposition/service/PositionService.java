package com.hro.core.cposition.service;

import com.hro.core.cposition.controller.request.PositionReq;
import com.hro.core.cposition.controller.response.CommonResp;
import com.hro.core.cposition.controller.response.PositionQueryPageResp;
import com.hro.core.cposition.dao.PositionDao;
import com.hro.core.cposition.dao.PositionHistoryDao;
import com.hro.core.cposition.dao.model.Position;
import com.hro.core.cposition.dao.model.PositionHistory;
import com.hro.core.cposition.enums.StateCodeEnum;
import com.hro.core.cposition.threadpool.CommonTaskManager;
import com.hro.core.cposition.threadpool.task.PositionCaculateTask;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class PositionService {

    @Autowired
    private PositionDao positionDao;

    @Autowired
    private PositionHistoryDao positionHistoryDao;

    @Autowired
    private RedisService redisService;

    // 缓存Key
    private static final String CACHE_KEY_PREFIX = "POSITION_";

    // 缓存Key
    private static final long CACHE_EXPIRE_TIME = 30l*60;

    /**
     * 添加信息
     * @param req
     * @return
     */
    @Transactional
    public CommonResp saveOrUpdateInfo(PositionReq req) {
        CommonResp resp = new CommonResp();
        resp.setMsg("添加/更新位置信息失败");

        Position position = req.getPosition();
        position.setCreateTime(new Date());

        if(StringUtils.isBlank(position.getDevid())) {
            position.setDevid(UUID.randomUUID().toString());
        } else {
            Position oldPosition = (Position) redisService.getObj(CACHE_KEY_PREFIX + position.getDevid(), Position.class);
            if(oldPosition != null) {
                // 开启线程计算距离差
                PositionCaculateTask task = new PositionCaculateTask(oldPosition, position);
                CommonTaskManager.getInstance().addTask(task);
            }
        }

        int cnt = positionDao.saveOrUpdateInfo(position);
        if(cnt > 0) {
            redisService.setObj(CACHE_KEY_PREFIX + position.getDevid(), position, CACHE_EXPIRE_TIME);

            PositionHistory history = new PositionHistory();
            history.setBdLat(position.getBdLat());
            history.setBdLng(position.getBdLng());
            history.setCreateTime(new Date());
            history.setDevid(position.getDevid());
            history.setLat(position.getLat());
            history.setLng(position.getLng());

            positionHistoryDao.addInfo(history);

            resp.setCode(StateCodeEnum.SUCCESS.getValue());
            resp.setMsg("添加/更新位置信息成功");
        }

        return resp;
    }


    /**
     * 删除信息
     * @param req
     * @return
     */
    public CommonResp delInfo(PositionReq req) {
        CommonResp resp = new CommonResp();
        resp.setMsg("删除位置信息失败");

        Position position = req.getPosition();

        int cnt = positionDao.delInfoById(position.getDevid());
        if(cnt > 0) {
            resp.setCode(StateCodeEnum.SUCCESS.getValue());
            resp.setMsg("删除位置信息成功");
        }

        return resp;
    }

    /**
     * 分页查询
     * @return
     */
    public PositionQueryPageResp queryInfoPage(PositionReq req) {
        PositionQueryPageResp resp = new PositionQueryPageResp();

        int total = positionDao.getRecordTotal(null);
        List<Position> result = positionDao.queryPageRecord(req);
        resp.setResult(result);
        resp.setTotal(total);
        resp.setCode(StateCodeEnum.SUCCESS.getValue());
        resp.setPageNum(req.getPageNum());
        resp.setPageSize(req.getPageSize());

        return resp;
    }

    /**
     * 根据设备ID查询
     * @return
     */
    public Position queryInfoByDevid(String devid) {
        Position position = null;
        // 先从缓存中读取数据
        Position oldPosition = (Position) redisService.getObj(CACHE_KEY_PREFIX + devid, Position.class);
        if(oldPosition != null) {
            return oldPosition;
        }

        List<Position> result = positionDao.queryInfoByDevid(devid);
        if(!CollectionUtils.isEmpty(result)) {
            position = result.get(0);
            // 把数据放入缓存
            redisService.setObj(CACHE_KEY_PREFIX + position.getDevid(), position, CACHE_EXPIRE_TIME);
        }
        return position;
    }

}
