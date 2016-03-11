package com.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ArithmeticApp 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans_aop.xml");  
        Arithmetic arithmeticBean = (Arithmetic) context.getBean("arithmeticBean");  
        System.out.println("Division = " + arithmeticBean.divide(8, 2));
    }
}
