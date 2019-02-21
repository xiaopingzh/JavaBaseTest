package com.ping.pattern.chain;

/**
 * 一个简单的关于日志的责任链Demo
 * Author:zhangxiaoping04@meituan.com
 * Date:2019/2/21
 * Time:下午8:12
 */
public class LoggerChainManger {

    /**
     * 创建责任链：将链表返回
     * @return
     */
    public static AbstractLogger createLoggerChainInstance() {
        AbstractLogger infoLogger = new InfoLogger(LogLevelEnum.INFO);
        AbstractLogger debugLogger = new DebugLogger(LogLevelEnum.DEBUG);
        AbstractLogger warnLogger = new WarnLogger(LogLevelEnum.WARN);
        AbstractLogger errorLogger = new ErrorLogger(LogLevelEnum.ERROR);

        infoLogger.setNextLogger(debugLogger);
        debugLogger.setNextLogger(warnLogger);
        warnLogger.setNextLogger(errorLogger);
        return infoLogger;
    }
}
