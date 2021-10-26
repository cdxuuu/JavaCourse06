package com.cdx.course.week05.homeword;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentMain {
    public static void main(String[] args) {
        String[] locations = {"applicationContext.xml"};
        ApplicationContext ctx = new ClassPathXmlApplicationContext(locations);
        Student student = (Student) ctx.getBean("student");
        System.out.println(student);
    }
}
