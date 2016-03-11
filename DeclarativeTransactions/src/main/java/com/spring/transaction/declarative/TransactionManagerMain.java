package com.spring.transaction.declarative;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.transaction.declarative.entity.UserEntity;
import com.spring.transaction.declarative.json.User;
import com.spring.transaction.declarative.service.UserService;
import com.spring.transaction.declarative.service.UserServiceImpl;

public class TransactionManagerMain {

	public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
                "beans.xml");
 
        UserService userService = ctx.getBean("userService",
                UserServiceImpl.class);
 
        UserEntity userEntity = new UserEntity(2, "Anant", 222);
        User user = userService.createUser(userEntity);
        System.out.println("user = " + user);
        ctx.close();
	}

}
