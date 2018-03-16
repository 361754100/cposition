package com.hro.core.cposition.dao;


import com.hro.core.cposition.controller.request.PositionReq;
import com.hro.core.cposition.dao.mapper.PositionHistoryMapper;
import com.hro.core.cposition.dao.model.PositionHistory;
import com.hro.core.cposition.dao.model.PositionHistoryExample;
import com.hro.core.cposition.utils.RowBoundsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

/**
 * 实信息Dao
 */
@Repository
public class PositionHistoryDao {

    @Autowired
    private PositionHistoryMapper positionHistoryMapper;

    /**
     * 添加信息
     * @param history
     * @return
     */
    public int addInfo(PositionHistory history) {
        int cnt = positionHistoryMapper.insertSelective(history);

        return cnt;
    }

    /**
     * 根据主键删除信息
     * @param devid
     * @return
     */
    public int delInfoById(String devid) {
        PositionHistoryExample example = new PositionHistoryExample();
        example.createCriteria().andDevidEqualTo(devid);

        int cnt = positionHistoryMapper.deleteByExample(example);
        return cnt;
    }

    /**
     * 修改信息
     * @param history
     * @return
     */
    public int updateInfo(PositionHistory history) {
        PositionHistoryExample example = new PositionHistoryExample();
        example.createCriteria().andDevidEqualTo(history.getDevid());

        int cnt = positionHistoryMapper.updateByExampleSelective(history, example);
        return cnt;
    }

    /**
     * 根据用户ID获取信息
     * @param devid
     * @return
     */
    public PositionHistory getInfoById(String devid) {
        PositionHistory history = null;

        PositionHistoryExample example = new PositionHistoryExample();
        example.createCriteria().andDevidEqualTo(devid);

        List<PositionHistory> result = positionHistoryMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(result)) {
            history = result.get(0);
        }
        return history;
    }

    /**
     * 获取记录总数
     * @return
     */
    public int getRecordTotal(Map<String, String> conditions) {
        int total = positionHistoryMapper.countByExample(null);
        return total;
    }

    /**
     *
     * @return
     */
    public List<PositionHistory> queryPageRecord(PositionReq req) {
        int pageNum = req.getPageNum();
        int pageSize = req.getPageSize();

        PositionHistoryExample example = new PositionHistoryExample();

        List<PositionHistory> result = positionHistoryMapper.selectByExampleWithRowbounds(example, RowBoundsUtil.of(pageNum, pageSize));
        return result;
    }

}
