package com.spring.transaction.programmatic.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.spring.transaction.programmatic.entity.UserEntity;

public class UserDAOImpl implements UserDAO {

	private SessionFactory sessionFactory;
	private TransactionTemplate transactionTemplate;
	
	public UserEntity createUser(final UserEntity userEntity) {
		
		transactionTemplate.execute(new TransactionCallback<Void>() {

			public Void doInTransaction(TransactionStatus transactionStatus) {
				Session session = null;
				try {
					session = sessionFactory.openSession();
					session.save(userEntity);
					session.flush();
					System.out.println("User inserted: " + userEntity.getName());
				}
				catch(Exception e) {
					transactionStatus.setRollbackOnly();
					System.out.println("User insertion failed");
					e.printStackTrace();
				}
				finally {
					session.close();
				}
				return null;
			}
		});
		return userEntity;
	}

	public UserEntity getUserById(int id) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM UserEntity WHERE id = :ID");
		query.setParameter("ID", id);
		List<UserEntity> userEntities = query.list();
		if (userEntities == null || userEntities.size() == 0)
			return null;
		else
			return userEntities.get(0);
	}

	public List<UserEntity> getAllUsers() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM UserEntity");
		List<UserEntity> userEntities = query.list();
		return userEntities;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public TransactionTemplate getTransactionTemplate() {
		return transactionTemplate;
	}

	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

}
