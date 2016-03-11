package com.spring.transaction.declarative.service;

import java.util.ArrayList;
import java.util.List;

import com.spring.transaction.declarative.dao.UserDAO;
import com.spring.transaction.declarative.entity.UserEntity;
import com.spring.transaction.declarative.json.User;

public class UserServiceImpl implements UserService {

	private UserDAO userDao;
	
	public User createUser(UserEntity userEntity) {
		userEntity = userDao.createUser(userEntity);
		return new User(userEntity.getId(), userEntity.getName(), userEntity.getPhone());
	}

	public List<User> createUsers(List<UserEntity> userEntities) {
		userEntities = userDao.createUsers(userEntities);
		List<User> userList = new ArrayList<User>();
		for(UserEntity userEntity: userEntities) {
			userList.add(new User(userEntity.getId(), userEntity.getName(), userEntity.getPhone()));
		}
		return userList;
	}

	public User getUserById(int id) {
		UserEntity userEntity = userDao.getUserById(id);
		return new User(userEntity.getId(), userEntity.getName(), userEntity.getPhone());
	}

	public List<User> getAllUsers() {
		List<UserEntity> userEntities = userDao.getAllUsers();
		List<User> userList = new ArrayList<User>();
		for(UserEntity userEntity: userEntities) {
			userList.add(new User(userEntity.getId(), userEntity.getName(), userEntity.getPhone()));
		}
		return userList;
	}

	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

}
