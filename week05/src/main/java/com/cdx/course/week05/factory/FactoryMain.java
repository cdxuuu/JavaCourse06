package com.cdx.course.week05.factory;

import com.cdx.course.week05.factory.child.Student;
import com.cdx.course.week05.factory.child.StudentFactory;
import com.cdx.course.week05.factory.child.Teacher;
import com.cdx.course.week05.factory.child.TeacherFactory;

public class FactoryMain {

    public static void main(String[] args) {
        StudentFactory studentFactory = new StudentFactory();
        Student student = studentFactory.produce();
        student.eat();

        TeacherFactory teacherFactory = new TeacherFactory();
        Teacher teacher = teacherFactory.produce();
        teacher.eat();
    }
}
