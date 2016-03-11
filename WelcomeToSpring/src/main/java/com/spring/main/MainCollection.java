package com.spring.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.beans.CollectionBean;

public class MainCollection {
	
	public static void main(String[] args) {
		
		//XML based bean configuration
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans_collection.xml");
		CollectionBean bean = (CollectionBean) context.getBean("collectionBean");


		System.out.println("List: " + bean.getCityList());
		System.out.println("Set: " + bean.getCountrySet());
		System.out.println("Map: " + bean.getZipCityMap());
		System.out.println("Props: " + bean.getCityCountryProps());
		context.registerShutdownHook();
	}
}
