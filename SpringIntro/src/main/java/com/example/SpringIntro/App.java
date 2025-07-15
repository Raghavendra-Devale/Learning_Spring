package com.example.SpringIntro;

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
      ApplicationContext cont = new ClassPathXmlApplicationContext("com/example/SpringIntro/beans.xml");
      Laptop lap = cont.getBean("laptop",Laptop.class);
      lap.callProcess();
        
    }
}
