package com.hro.core.cposition.dao.model;

import java.io.Serializable;
import java.util.Date;

public class PositionHistory implements Serializable {
    private Integer id;

    private String devid;

    private Double lng;

    private Double lat;

    private Double bdLng;

    private Double bdLat;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
}