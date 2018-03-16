package com.hro.core.cposition.dao.mapper;

import com.hro.core.cposition.dao.model.PositionHistory;
import com.hro.core.cposition.dao.model.PositionHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface PositionHistoryMapper {
    int countByExample(PositionHistoryExample example);

    int deleteByExample(PositionHistoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PositionHistory record);

    int insertSelective(PositionHistory record);

    List<PositionHistory> selectByExampleWithRowbounds(PositionHistoryExample example, RowBounds rowBounds);

    List<PositionHistory> selectByExample(PositionHistoryExample example);

    PositionHistory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PositionHistory record, @Param("example") PositionHistoryExample example);

    int updateByExample(@Param("record") PositionHistory record, @Param("example") PositionHistoryExample example);

    int updateByPrimaryKeySelective(PositionHistory record);

    int updateByPrimaryKey(PositionHistory record);
}