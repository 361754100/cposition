package com.hro.core.cposition.controller.response;

/**
 * 通用响应对象
 */
public class CommonResp {
    /**
     * 状态码
     */
    private int code = -1;

    /**
     * 处理结果
     */
    private String msg;

    /**
     * 记录总数
     */
    private int total;

    /**
     * 当前页
     */
    private int pageNum;

    /**
     * 每页大小
     */
    private int pageSize;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

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
        return "CommonResp{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
