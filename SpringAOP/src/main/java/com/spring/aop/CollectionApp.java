package com.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionApp {

	public static void main(String args[]) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        CollectionHandler ch = (CollectionHandler)context.getBean("collectionHandler");
        //System.out.println("Calling addElementsInVector()");
        ch.addElementsInVector();
        //System.out.println("Calling addElementsInArrayList()");
        ch.addElementsInArrayList();
	}
}
