package com.spring.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.beans.MessagePrinterBean;

public class MainApp {
	
	public static void main(String[] args) {
		
		//XML based bean configuration
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans_simple.xml");
		MessagePrinterBean obj = (MessagePrinterBean) context.getBean("messagePrinter");
		MessagePrinterBean obj_2 = (MessagePrinterBean) context.getBean("messagePrinter");
		
		//Java annotation based bean configuration
//		AbstractApplicationContext context_2 = new AnnotationConfigApplicationContext(AppConfig.class);
//		MessagePrinterBean obj = (MessagePrinterBean) context.getBean("messagePrinter");
//		obj.setMessage("Hello Spring!!");

		obj.printMessage();
		obj_2.printMessage();
		context.registerShutdownHook();
	}
}
