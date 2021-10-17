package com.cdx.course.week04.homework;

import com.cdx.course.week04.homework.params.LockParam;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 待优化
 */
public class LockThread {
    static ExecutorService executorService = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        executorService.execute(()->{
            LockParam.getlock();
            try {
                Thread.sleep(5000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("im private");
            LockParam.release();
        });
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (!LockParam.getlock());
        System.out.println("im main");
        LockParam.release();
    }
}
