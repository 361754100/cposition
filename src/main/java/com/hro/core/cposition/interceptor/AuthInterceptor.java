package com.hro.core.cposition.interceptor;

import com.hro.core.cposition.common.Constant;
import com.hro.core.cposition.utils.RsaUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;

/**
 * 权限拦截器
 */
@Component
public class AuthInterceptor implements HandlerInterceptor{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // 对外的RSA密钥明文
    private static final String TEST_AUTH_KEY = "Cposition_Auth_Key";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authHeader = request.getHeader(Constant.X_AUTH_HEADER);

        String reqFrom = this.getReqIpAddr(request);
        String reqSessionId = request.getRequestedSessionId();
        String reqUrl = request.getRequestURL().toString();

        logger.debug("reqSessionId={}, authHeader={}, reqFrom={}, reqUrl={}", reqSessionId, authHeader, reqFrom, reqUrl);

        if(reqUrl.indexOf("/swagger") != -1 || reqUrl.indexOf("/error") != -1
                || reqUrl.indexOf("/v2/api-docs") != -1) {
            return true;
        }

        if(authHeader == null) {
            return false;
        }

        //--解密数据
        byte[] decryptData = RsaUtil.decryptData(Base64.getDecoder().decode(authHeader.getBytes("UTF-8")));
        String authKey = new String(decryptData == null?"".getBytes():decryptData);
        logger.debug("authKey={}", authKey);

        if(!TEST_AUTH_KEY.equals(authKey)) {
            return false;
        }

        return true;
    }

    /**
     * 获取请求端的IP 地址
     * @param request
     * @return
     */
    public String getReqIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
