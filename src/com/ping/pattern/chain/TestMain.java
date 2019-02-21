package com.ping.pattern.chain;

/**
 * Author:zhangxiaoping04@meituan.com
 * Date:2019/2/21
 * Time:下午8:17
 */
public class TestMain {

    public static void main(String[] args){

        AbstractLogger abstractLogger = LoggerChainManger.createLoggerChainInstance();

        abstractLogger.logMessage(LogLevelEnum.INFO, "infoMessage");
        abstractLogger.logMessage(LogLevelEnum.DEBUG, "debugMessage");
        abstractLogger.logMessage(LogLevelEnum.WARN, "warnMessage");
        abstractLogger.logMessage(LogLevelEnum.ERROR, "errorMessage");
    }

}
