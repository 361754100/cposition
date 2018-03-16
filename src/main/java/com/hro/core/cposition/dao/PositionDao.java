package com.hro.core.cposition.dao;


import com.hro.core.cposition.controller.request.PositionReq;
import com.hro.core.cposition.dao.mapper.PositionMapper;
import com.hro.core.cposition.dao.model.Position;
import com.hro.core.cposition.dao.model.PositionExample;
import com.hro.core.cposition.utils.RowBoundsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 实信息Dao
 */
@Repository
public class PositionDao {

    @Autowired
    private PositionMapper positionMapper;

    /**
     * 添加信息
     * @param position
     * @return
     */
    public int addInfo(Position position) {
        int cnt = 0;
        PositionExample example = new PositionExample();
        example.createCriteria().andDevidEqualTo(position.getDevid());

        boolean isExist = positionMapper.countByExample(example) > 0;
        if(isExist) {
            return cnt;
        }

        cnt = positionMapper.insertSelective(position);

        return cnt;
    }

    /**
     * 添加或更新信息
     * @param position
     * @return
     */
    public int saveOrUpdateInfo(Position position) {
        int cnt = 0;
        PositionExample example = new PositionExample();
        example.createCriteria().andDevidEqualTo(position.getDevid());

        boolean isExist = positionMapper.countByExample(example) > 0;
        if(!isExist) {
            cnt = positionMapper.insertSelective(position);
        } else {
            Position tmp = new Position();
            tmp.setDevid(position.getDevid());
            tmp.setBdLat(position.getBdLat());
            tmp.setBdLng(position.getBdLng());
            tmp.setLng(position.getLng());
            tmp.setLat(position.getLat());
            tmp.setUpdateTime(new Date());

            cnt = positionMapper.updateByExampleSelective(tmp, example);
        }

        return cnt;
    }

    /**
     * 根据主键删除信息
     * @param devid
     * @return
     */
    public int delInfoById(String devid) {
        PositionExample example = new PositionExample();
        example.createCriteria().andDevidEqualTo(devid);

        int cnt = positionMapper.deleteByExample(example);
        return cnt;
    }

    /**
     * 修改信息
     * @param position
     * @return
     */
    public int updateInfo(Position position) {
        PositionExample example = new PositionExample();
        example.createCriteria().andDevidEqualTo(position.getDevid());

        int cnt = positionMapper.updateByExampleSelective(position, example);
        return cnt;
    }

    /**
     * 根据用户ID获取信息
     * @param devid
     * @return
     */
    public Position getInfoById(String devid) {
        Position Position = null;

        PositionExample example = new PositionExample();
        example.createCriteria().andDevidEqualTo(devid);

        List<Position> result = positionMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(result)) {
            Position = result.get(0);
        }
        return Position;
    }

    /**
     * 获取记录总数
     * @return
     */
    public int getRecordTotal(Map<String, String> conditions) {
        int total = positionMapper.countByExample(null);
        return total;
    }

    /**
     *
     * @return
     */
    public List<Position> queryPageRecord(PositionReq req) {
        int pageNum = req.getPageNum();
        int pageSize = req.getPageSize();

        PositionExample example = new PositionExample();

        List<Position> result = positionMapper.selectByExampleWithRowbounds(example, RowBoundsUtil.of(pageNum, pageSize));
        return result;
    }

}
