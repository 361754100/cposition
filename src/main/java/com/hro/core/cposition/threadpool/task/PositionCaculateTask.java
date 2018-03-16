package com.hro.core.cposition.threadpool.task;

import com.alibaba.fastjson.JSON;
import com.hro.core.cposition.common.Constant;
import com.hro.core.cposition.config.RestfulApi;
import com.hro.core.cposition.dao.model.Position;
import com.hro.core.cposition.utils.SpringUtil;
import com.hro.core.cposition.utils.StringUtils;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * 坐标差计算task
 */
public class PositionCaculateTask implements Runnable {

    private Position oldPosition;
    private Position newPosition;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     *
     * @param oldPosition 旧位置坐标
     * @param newPosition 新位置坐标
     */
    public PositionCaculateTask(Position oldPosition, Position newPosition) {
        this.oldPosition = oldPosition;
        this.newPosition = newPosition;
    }

    @Override
    public void run() {
        RestfulApi restfulApi = SpringUtil.getBean(RestfulApi.class);
        String apiUrl = restfulApi.getCmanager_alarmSet_queryInfoByDevid();

        double dist = this.getPositionDistance();

        final OkHttpClient client = new OkHttpClient();

        String devid = newPosition.getDevid();

        RequestBody formBody = new FormBody.Builder()
                .add("devid", devid)
                .build();

        Request.Builder builder = new Request.Builder();
        builder.url(apiUrl);
        builder.addHeader(Constant.X_AUTH_HEADER, "rsaKey");
        builder.method(Constant.METHOD_POST, formBody);

        final Request request = builder.build();

        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (Exception e) {
            logger.error("请求接口响应异常", e);
        }

        if (response == null || !response.isSuccessful()) {
            logger.info("请求失败 apiUrl={}", apiUrl);
            return;
        }

        try {
            Map map = (Map) JSON.parse(response.body().string());
            String alarmRadius = StringUtils.toString(map.get("alarmRadius"));
            if(StringUtils.isBlank(alarmRadius)) {
                return;
            }

            // 大于5米则报警
            if(dist > Double.parseDouble(alarmRadius)) {
                logger.info("设备：Devid={}，位置偏移告警，偏移量：{}米", new Object[]{devid, dist});
            }
        }catch (Exception e) {
            logger.error("解析接口响应异常", e);
        }

    }

    /**
     * 计算两个坐标间的距离
     * @return
     */
    public double getPositionDistance(){
        /**
         * 计算两点之间距离
         * @param start
         * @param end
         * @return String  多少m ,  多少km
         */

        double lat1 = (Math.PI/180)*newPosition.getBdLat();
        double lat2 = (Math.PI/180)*oldPosition.getBdLat();

        double lon1 = (Math.PI/180)*newPosition.getBdLng();
        double lon2 = (Math.PI/180)*oldPosition.getBdLng();

        //地球半径
        final double earthRaduis = 6371.004;

        //两点间距离 m，如果想要米的话，结果*1000就可以了
        double dis =  Math.acos(Math.sin(lat1)*Math.sin(lat2)+Math.cos(lat1)*Math.cos(lat2)*Math.cos(lon2-lon1))* earthRaduis;
        return dis * 1000; //返回米

//        NumberFormat nFormat = NumberFormat.getNumberInstance();  //数字格式化对象
//        if(dis < 1){               //当小于1千米的时候用,用米做单位保留一位小数
//
//            nFormat.setMaximumFractionDigits(1);    //已可以设置为0，这样跟百度地图APP中计算的一样
//            dis *= 1000;
//
//            return nFormat.format(dis)+"m";
//        }else{
//            nFormat.setMaximumFractionDigits(2);
//            return nFormat.format(dis)+"km";
//        }
    }
}
