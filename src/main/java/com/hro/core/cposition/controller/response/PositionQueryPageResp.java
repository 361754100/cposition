package com.hro.core.cposition.controller.response;

import com.hro.core.cposition.dao.model.Position;

import java.util.List;

/**
 * 分页信息查询响应
 */
public class PositionQueryPageResp extends CommonResp {

    /**
     * 查询结果
     */
    private List<Position> result;

    public List<Position> getResult() {
        return result;
    }

    public void setResult(List<Position> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "PositionQueryPageResp{" +
                "pageNum=" + super.getPageNum() +
                ", pageSize=" + super.getPageSize() +
                ", total="+ super.getTotal() +
                ", msg="+ super.getMsg() +
                ", code="+ super.getCode() +
                ", result=" + result +
                '}';
    }

}
