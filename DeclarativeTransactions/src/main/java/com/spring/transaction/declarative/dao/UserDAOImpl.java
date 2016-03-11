package com.spring.transaction.declarative.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.transaction.declarative.entity.UserEntity;

public class UserDAOImpl implements UserDAO {

	private JdbcTemplate jdbcTemplate;
	
	//@Transactional(propagation=Propagation.REQUIRED)
	public UserEntity createUser(UserEntity userEntity) {
		int updateCount = 
			jdbcTemplate.update("INSERT INTO USER_TBL (ID, NAME, PHONE) VALUES(?, ?, ?)",
			new Object[] {userEntity.getId(), userEntity.getName(), userEntity.getPhone()});

		//For testing rollback
//		jdbcTemplate.update("INSERT INTO USER_TB (ID, NAME, PHONE) VALUES(?, ?, ?)",
//		new Object[] {userEntity.getId(), userEntity.getName(), userEntity.getPhone()});
		
		if (updateCount == 1) {
			System.out.println("User inserted: " + userEntity.getName());
			return userEntity;
		}
		return null;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public List<UserEntity> createUsers(List<UserEntity> userEntities) {
		for(UserEntity userEntity: userEntities) {
			jdbcTemplate.update("INSERT INTO USER_TBL (ID, NAME, PHONE) VALUES(?, ?, ?)",
			new Object[] {userEntity.getId(), userEntity.getName(), userEntity.getPhone()});
		}
		return userEntities;
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public UserEntity getUserById(int id) {
		List<Map<String, Object>> userList = jdbcTemplate.queryForList("SELECT ID, NAME, PHONE FROM USER_TBL WHERE ID = ?",
				new Object[] {id});
		if (userList != null && userList.size() == 1) {
			Map<String, Object> mapUser = userList.get(0);
			return new UserEntity(((java.math.BigDecimal)mapUser.get("ID")).intValue(), (String)mapUser.get("NAME"), ((java.math.BigDecimal)mapUser.get("PHONE")).intValue());
		}
		return null;
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public List<UserEntity> getAllUsers() {
		List<Map<String, Object>> userList = jdbcTemplate.queryForList("SELECT ID, NAME, PHONE FROM USER_TBL");
		List<UserEntity> userEntities = new ArrayList<UserEntity>();
		if (userList != null && userList.size() > 0) {
			for(int i=0; i<userList.size(); i++) {
				Map<String, Object> mapUser = userList.get(i);
				UserEntity userEntity = 
						new UserEntity(((java.math.BigDecimal)mapUser.get("ID")).intValue(), (String)mapUser.get("NAME"), ((java.math.BigDecimal)mapUser.get("PHONE")).intValue());
				userEntities.add(userEntity);
			}
			return userEntities;
		}
		return null;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
