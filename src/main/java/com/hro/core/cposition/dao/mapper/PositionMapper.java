package com.hro.core.cposition.dao.mapper;

import com.hro.core.cposition.dao.model.Position;
import com.hro.core.cposition.dao.model.PositionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface PositionMapper {
    int countByExample(PositionExample example);

    int deleteByExample(PositionExample example);

    int deleteByPrimaryKey(String devid);

    int insert(Position record);

    int insertSelective(Position record);

    List<Position> selectByExampleWithRowbounds(PositionExample example, RowBounds rowBounds);

    List<Position> selectByExample(PositionExample example);

    Position selectByPrimaryKey(String devid);

    int updateByExampleSelective(@Param("record") Position record, @Param("example") PositionExample example);

    int updateByExample(@Param("record") Position record, @Param("example") PositionExample example);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);
}