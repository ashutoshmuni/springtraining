package com.spring.transaction.declarative.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.transaction.declarative.entity.UserEntity;
import com.spring.transaction.declarative.json.User;

@Service
public interface UserService {
	User createUser(UserEntity userEntity);
	List<User> createUsers(List<UserEntity> userEntities);
	User getUserById(int id);
	List<User> getAllUsers();
}
