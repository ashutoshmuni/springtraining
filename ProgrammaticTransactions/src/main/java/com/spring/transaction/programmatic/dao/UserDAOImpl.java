package com.spring.transaction.programmatic.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.spring.transaction.programmatic.entity.UserEntity;

public class UserDAOImpl implements UserDAO {

	private JdbcTemplate jdbcTemplate;
	private TransactionTemplate transactionTemplate;
	
	public UserEntity createUser(final UserEntity userEntity) {
		
		transactionTemplate.execute(new TransactionCallback<Integer>() {

			public Integer doInTransaction(TransactionStatus transactionStatus) {
				int insertCount = 0;
				try {
					insertCount = 
						jdbcTemplate.update("INSERT INTO USER_TBL (ID, NAME, PHONE) VALUES(?, ?, ?)",
						new Object[] {userEntity.getId(), userEntity.getName(), userEntity.getPhone()});
					if (insertCount == 1) {
						System.out.println("User inserted: " + userEntity.getName());
					}
				}
				catch(Exception e) {
					transactionStatus.setRollbackOnly();
					System.out.println("User insertion failed");
					e.printStackTrace();
				}
				return insertCount;
			}
		});
		return userEntity;
	}

	public UserEntity getUserById(int id) {
		List<Map<String, Object>> userList = jdbcTemplate.queryForList("SELECT ID, NAME, PHONE FROM USER_TBL WHERE ID = ?",
				new Object[] {id});
		if (userList != null && userList.size() == 1) {
			Map<String, Object> mapUser = userList.get(0);
			return new UserEntity(((java.math.BigDecimal)mapUser.get("ID")).intValue(), (String)mapUser.get("NAME"), ((java.math.BigDecimal)mapUser.get("PHONE")).intValue());
		}
		return null;
	}

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

	public TransactionTemplate getTransactionTemplate() {
		return transactionTemplate;
	}

	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

}
