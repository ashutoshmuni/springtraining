package com.spring.transaction.programmatic.dao;

import java.util.List;

import com.spring.transaction.programmatic.entity.UserEntity;

public interface UserDAO {
	UserEntity createUser(UserEntity userEntity);
	UserEntity getUserById(int id);
	List<UserEntity> getAllUsers();
}
