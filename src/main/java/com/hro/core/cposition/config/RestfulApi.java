package com.hro.core.cposition.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RestfulApi {

    @Value("${restfulApi.cmanager.alarmSet.queryInfoByDevid}")
    private String cmanager_alarmSet_queryInfoByDevid;

    public String getCmanager_alarmSet_queryInfoByDevid() {
        return cmanager_alarmSet_queryInfoByDevid;
    }

}
