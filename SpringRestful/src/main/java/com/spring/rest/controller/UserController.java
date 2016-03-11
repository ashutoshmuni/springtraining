package com.spring.rest.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.entity.Registration;

import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/shopping")
public class UserController {
	
	@RequestMapping("/hello")
	public String sayHello(@RequestParam(value="name", defaultValue="Ivan") String name) {
		return "Hello " + name;
	}

	@RequestMapping(value="/register", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public String registerUser(@RequestBody Registration register) {
		System.out.println("Registered: " + register);
		return "{\"result\": \"SUCCESS\"}";
	}
}
