package com.spring.transaction.declarative.dao;

import java.util.List;

import com.spring.transaction.declarative.entity.UserEntity;

public interface UserDAO {
	UserEntity createUser(UserEntity userEntity);
	List<UserEntity> createUsers(List<UserEntity> userEntities);
	UserEntity getUserById(int id);
	List<UserEntity> getAllUsers();
}
