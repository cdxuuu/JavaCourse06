package com.cdx.course.week04.homework.params;

import lombok.Data;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Data
public class LockParam {

    static Lock lock = new ReentrantLock(false);

    public static boolean getlock() {
        try {
           return lock.tryLock(10, TimeUnit.SECONDS);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void release() {
        lock.unlock();
    }
}
