package com.hro.core.cposition.controller.request;

import com.hro.core.cposition.dao.model.Position;

/**
 * 实时位置请求
 */
public class PositionReq extends CommonReq{

    //位置信息
    private Position position;

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "PositionReq{" +
                "position=" + position +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
