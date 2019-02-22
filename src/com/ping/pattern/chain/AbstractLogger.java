package com.ping.pattern.chain;

/**
 * 责任链关键抽象类
 * Author:zhangxiaoping
 * Date:2019/2/21
 * Time:下午8:00
 */
public abstract class AbstractLogger {

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    /**
     * 责任链中的下一个元素
     */
    protected AbstractLogger nextLogger;

    protected LogLevelEnum logLevelEnum;

    /**
     * 责任链提交方法入口
     * @param logLevelEnum
     * @param message
     */
    public void logMessage(LogLevelEnum logLevelEnum, String message) {
        if (this.logLevelEnum.getLevel() <= logLevelEnum.getLevel()) {
            write(message);
        }
        if (nextLogger != null) {
            nextLogger.logMessage(logLevelEnum, message);
        }
    }

    /**
     * 定义的抽象方法
     * @param message
     */
    abstract protected void write(String message);
}
