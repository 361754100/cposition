package com.hro.core.cposition.utils;

import com.alibaba.fastjson.JSON;
import com.hro.core.cposition.common.Constant;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * 基于OkHttp 的请求工具类
 */
public class HttpUtil {

    private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    public static final MediaType JSON_TYPE = MediaType.parse("application/json; charset=utf-8");

    /**
     * 用POST方式发送HTTP请求，参数格式为Json
     * @param apiUrl
     * @param jsonParams
     * @return
     */
    public static Map postJson(String apiUrl, String jsonParams) {
        Map<?,?> rtMap = null;

        final OkHttpClient client = new OkHttpClient();

        RequestBody formBody = RequestBody.create(JSON_TYPE, jsonParams);

        Request.Builder builder = new Request.Builder();
        builder.url(apiUrl);
        builder.addHeader(Constant.X_AUTH_HEADER, "F4J+mzSLsoqwf+YlZH0pVwcR2rGFt3/ZMDhI5hQieKBNIJHmAtxfwnjYBqUkE5w8Il3fZwA1yOt3S/ilSNRm7GAtWMVK3Sm/U3a/dKI2f3JWsWZjm+P2Mef26w2kndPE0T5o6YMLO5blTeybYmZBpL0nMcYs+6DO6/bS5MhM3NY=");
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
            return rtMap;
        }

        try {
            rtMap = (Map) JSON.parse(response.body().string());
        }catch (Exception e) {
            logger.error("解析接口响应异常", e);
        }

        return rtMap;
    }

}
