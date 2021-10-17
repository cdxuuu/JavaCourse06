package com.cdx.course.week04.homework;

import java.util.concurrent.*;

public class FutureThread {
    static ExecutorService executorService = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(5000);
                return "im private";
            }
        });

        executorService.execute(futureTask);

        try {
            String s = futureTask.get();
            System.out.println(s);
            System.out.println("im main");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }
    }
}
