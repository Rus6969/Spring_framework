package com.cybertek;

import com.cybertek.interfaces.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CyberApp {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("config.xml");

        Course course1 = container.getBean("java", Course.class);


        Course course2 = container.getBean("java", Course.class);

        System.out.println("Pointing same object " + (course1==course2));
        System.out.println("memory location "+ course1);
        System.out.println("memory location "+ course2);
        // if singleto will return true  address will be same , chamge in
        // config xml settings to prototype to create different object reference with new object

    }
}
