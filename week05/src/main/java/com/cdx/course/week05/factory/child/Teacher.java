package com.cdx.course.week05.factory.child;

import com.cdx.course.week05.factory.parent.Human;

public class Teacher implements Human {

    @Override
    public void eat() {
        System.out.println("teacher eat");
    }
}
