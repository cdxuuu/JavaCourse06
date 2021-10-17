package com.cdx.course.week04.homework;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallableThread {

    static ExecutorService executorService = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(5000);
                return "im private";
            }
        };

        try {
            String call = callable.call();
            System.out.println(call);
            System.out.println("im main");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }

    }
}
