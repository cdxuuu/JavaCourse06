package com.cdx.course.week04.homework;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 使用countDown
 */
public class CountDownLatchMainThread {
    static CountDownLatch countDownLatch = new CountDownLatch(1);

    static ExecutorService executorService = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        executorService.execute(() ->{
            try {
                Thread.sleep(5000);
                countDownLatch.countDown();
                System.out.println("im private");
            }catch (Exception e) {
                e.printStackTrace();
            }
        });

        try {
            countDownLatch.await();
            System.out.println("im main");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }
    }
}
