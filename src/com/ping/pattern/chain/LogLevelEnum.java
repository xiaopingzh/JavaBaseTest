package com.ping.pattern.chain;

/**
 * Author:zhangxiaoping04@meituan.com
 * Date:2019/2/21
 * Time:下午8:02
 */
public enum LogLevelEnum {

    INFO(1),
    DEBUG(2),
    WARN(3),
    ERROR(4);

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    private int level;
    LogLevelEnum(int level) {
        this.level = level;
    }
}
