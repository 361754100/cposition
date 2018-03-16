package com.hro.core.cposition.controller.request;

import java.io.Serializable;

/**
 * 通用请求
 */
public class CommonReq implements Serializable{

    /**
     * 跳转页数
     */
    int pageNum;

    /**
     * 每页大小
     */
    int pageSize;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "CommonReq{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
