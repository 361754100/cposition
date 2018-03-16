package com.hro.core.cposition.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志输出工具类
 */
public class LogUtil {

    private static final Logger log = LoggerFactory.getLogger(LogUtil.class);

    public static void info(String msg) {
        log.info(msg);
    }

    public static void info(String msg, Object obj) {
        log.info(msg, obj);
    }

    public static void debug(String msg) {
        log.debug(msg);
    }

    public static void debug(String msg, Object obj) {
        log.debug(msg, obj);
    }

    public static void error(String msg) {
        log.error(msg);
    }

    public static void error(String msg, Object obj) {
        log.error(msg, obj);
    }
}
