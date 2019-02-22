package com.ping.thread.status;

import java.util.Date;
import java.util.List;

/**
 * Author:zhangxiaoping04@meituan.com
 * Date:2018/1/9
 * Time:下午7:15
 */
public class ThreadStatusTest {

//    private List<Date> getWindowList(Date startTime, Date endTime) {
//        long start = startTime.getTime();
//        long end = endTime.getTime();
//
//        long windowSizeInMillis = 60000L;
//        long windowStart = start - start % windowSizeInMillis;
//        long windowEnd = end - end % windowSizeInMillis;
//        List<Date> windowList = Lists.newArrayList(new Date(windowStart));
//        long nextWindow = start + windowSizeInMillis;
//        for (; nextWindow <= windowEnd; nextWindow = nextWindow + windowSizeInMillis) {
//            Date window = new Date(nextWindow);
//            windowList.add(window);
//        }
//        return windowList;
//    }
//
//
//    public static void main(String[] args) {
//
//        new ThreadStatusTest().test();
//
//    }
}
