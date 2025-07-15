package com.example.SpringIntro;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
      
//    	ApplicationContext con = new ClassPathXmlApplicationContext("com/example/SpringIntro/beans.xml");
//    	Car car = (Car) con.getBean("car");
//    	car.drive();
    	ApplicationContext con = new ClassPathXmlApplicationContext("com/example/SpringIntro/beans.xml");
    	Laptop lap = (Laptop)con.getBean("laptop");
    	lap.start();
        
    }
}
