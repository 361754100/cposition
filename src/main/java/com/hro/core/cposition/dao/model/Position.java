package com.hro.core.cposition.dao.model;

import java.io.Serializable;
import java.util.Date;

public class Position implements Serializable {
    private String devid;

    private Double lng;

    private Double lat;

    private Double bdLng;

    private Double bdLat;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public String getDevid() {
        return devid;
    }

    public void setDevid(String devid) {
        this.devid = devid;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getBdLng() {
        return bdLng;
    }

    public void setBdLng(Double bdLng) {
        this.bdLng = bdLng;
    }

    public Double getBdLat() {
        return bdLat;
    }

    public void setBdLat(Double bdLat) {
        this.bdLat = bdLat;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Position{" +
                "devid='" + devid + '\'' +
                ", lng=" + lng +
                ", lat=" + lat +
                ", bdLng=" + bdLng +
                ", bdLat=" + bdLat +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}