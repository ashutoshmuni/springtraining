package com.spring.transaction.programmatic.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.transaction.programmatic.entity.UserEntity;
import com.spring.transaction.programmatic.json.User;

@Service
public interface UserService {
	User createUser(UserEntity userEntity);
	User getUserById(int id);
	List<User> getAllUsers();
}
