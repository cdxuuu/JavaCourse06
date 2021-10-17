package com.cdx.course.week04.homework;

import com.cdx.course.week04.homework.params.DelayQueueParam;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DelayQueueThread {
    static ExecutorService executorService = Executors.newFixedThreadPool(2);
    static DelayQueue<DelayQueueParam> delayQueueParams = new DelayQueue<>();
    public static void main(String[] args) {

        executorService.execute(()->{
            try {
                Thread.sleep(5000);
                System.out.println("im private");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            DelayQueueParam delayQueueParam = new DelayQueueParam();
            delayQueueParam.setStatus(true);
            delayQueueParams.add(delayQueueParam);
        });

        while (delayQueueParams.isEmpty() || !delayQueueParams.peek().getStatus()) {
        }

        System.out.println("im main");
        executorService.shutdown();
    }
}
