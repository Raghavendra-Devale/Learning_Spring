package com.example.XMLAutowiring;

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
       ApplicationContext context = new ClassPathXmlApplicationContext("com/example/XMLAutowiring/config.xml");
       Person p = context.getBean("person",Person.class);
       p.drive();
    }
}
