package com.cdx.course.week05.factory.child;

import com.cdx.course.week05.factory.parent.HumanFactory;

public class TeacherFactory implements HumanFactory {

    @Override
    public Teacher produce() {
        return new Teacher();
    }
}
