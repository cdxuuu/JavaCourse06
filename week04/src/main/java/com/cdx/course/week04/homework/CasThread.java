package com.cdx.course.week04.homework;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class CasThread {
    static ExecutorService executorService = Executors.newFixedThreadPool(2);
    static AtomicBoolean atomicBoolean = new AtomicBoolean(false);

    public static void main(String[] args) {
        executorService.execute(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("im private");
                atomicBoolean.compareAndSet(false, true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        while (!atomicBoolean.get());

        System.out.println("im main");
        executorService.shutdown();
    }
}
