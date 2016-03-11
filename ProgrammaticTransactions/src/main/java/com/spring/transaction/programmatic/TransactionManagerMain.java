package com.spring.transaction.programmatic;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.transaction.programmatic.entity.UserEntity;
import com.spring.transaction.programmatic.json.User;
import com.spring.transaction.programmatic.service.UserService;
import com.spring.transaction.programmatic.service.UserServiceImpl;

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
