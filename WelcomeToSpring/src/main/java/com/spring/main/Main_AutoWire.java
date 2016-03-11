package com.spring.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.beans.EmployeeBean;

public class Main_AutoWire {
	
	public static void main(String[] args) {
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans_autowire.xml");
		EmployeeBean bean = (EmployeeBean) context.getBean("employee");
		System.out.println("Employee: " + bean.getName() + "\t" + bean.getProject());
		context.registerShutdownHook();
	}
}
