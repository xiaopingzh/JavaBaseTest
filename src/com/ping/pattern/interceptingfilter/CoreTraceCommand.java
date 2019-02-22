package com.ping.pattern.interceptingfilter;

import java.lang.annotation.*;

/**
 * Author:zhangxiaoping04@meituan.com
 * Date:2019/2/22
 * Time:上午10:53
 */
@Target({ ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface CoreTraceCommand {
}
