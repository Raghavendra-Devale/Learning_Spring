package com.example.SpringMobile;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       ApplicationContext context = new ClassPathXmlApplicationContext("com/example/SpringMobile/beans.xml");
       Mobile mob = context.getBean("mobile",Mobile.class);
       mob.start();
    }
}
