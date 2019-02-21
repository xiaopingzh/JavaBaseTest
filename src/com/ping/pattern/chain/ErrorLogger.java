package com.ping.pattern.chain;

/**
 * Author:zhangxiaoping04@meituan.com
 * Date:2019/2/21
 * Time:下午8:10
 */
public class ErrorLogger extends AbstractLogger{

    public ErrorLogger(LogLevelEnum logLevelEnum) {
        this.logLevelEnum = logLevelEnum;
    }

    @Override
    protected void write(String message) {
        System.out.println("log level error :" + message);
    }
}
