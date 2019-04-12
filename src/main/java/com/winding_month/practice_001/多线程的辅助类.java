package com.winding_month.practice_001;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class 多线程的辅助类 {

    public final static int MAX_THREAD = 30;

    public static Semaphore s = new Semaphore(5);

    private static ExecutorService threadPool = Executors.newFixedThreadPool(MAX_THREAD);

    /**
     * Semaphare
     */
    public static void SemaphareTest() {

        for(int i=0; i<MAX_THREAD; i++) {
            threadPool.execute(new Runnable() {
                public void run() {

                    try {
                        s.acquire();   //获取许可
                        System.out.println("获取许可，执行操作...");
                        Integer d = (int)(Math.random() * 10);

                        Thread.sleep(d.longValue() * 1000);
                        s.release();   //释放许可
                    } catch (InterruptedException e) {
                        System.out.println("error");
                    }
                }
            });
        }
    }

    public static void main(String[] args) {
        SemaphareTest();
    }

}
