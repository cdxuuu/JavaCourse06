package com.cdx.course.week04.homework.params;

import lombok.Data;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

@Data
public class DelayQueueParam implements Delayed{

    private Boolean status = false;

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return 0;
    }
}
