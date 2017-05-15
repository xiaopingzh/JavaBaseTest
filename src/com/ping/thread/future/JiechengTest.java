package com.ping.thread.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by zhangxiaoping on 17/5/14.
 * 使用多线程并发实现1~100累加求和 非fork/Join
 */
public class JiechengTest {

    public static final ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
    public static CountDownLatch countDownLatch = new CountDownLatch(10);

    public static void main(String[] args){
        List<Future<Long>> list = new ArrayList<>();
        for(int i=1;i<11;i++){
            Future<Long> future = threadPoolExecutor.submit(new JieTask(10*(i-1) + 1,10*i));
            list.add(future);
            countDownLatch.countDown();
        }


        try {
            countDownLatch.await();
            long sum = 0;
            for(Future<Long> future:list){
                try {
                    System.out.println(future.get());
                    sum = sum + future.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            threadPoolExecutor.shutdown();
        }
    }

    static class JieTask implements Callable<Long>{

        private int start;
        private int end;


        public JieTask(int start,int end){
            this.start = start;
            this.end = end;
        }

        /**
         * 实现start到End的阶乘
         * @param start
         * @param end
         * @return
         */
        public long getValue(int start ,int end){
            int sum = 0;
            for(int i=start;i<=end;i++){
                sum = sum + i;
            }
            return sum;
        }

        @Override
        public Long call() throws Exception {
            return getValue(start,end);
        }
    }
}
