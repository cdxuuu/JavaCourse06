package com.cdx.course.week05.factory.child;

import com.cdx.course.week05.factory.parent.HumanFactory;

public class StudentFactory implements HumanFactory {

    @Override
    public Student produce() {
        return new Student();
    }
}
