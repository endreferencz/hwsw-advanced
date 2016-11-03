package com.epam.training.javasecurity.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

@Component
public class UserRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public User findByEmailAndPassword(String email, String password) {
		String query = "select u from User u where email = '" + email + "' and password = '" + password + "'";

		List<User> user = entityManager.createQuery(query, User.class).getResultList();

		return user.size() == 1 ? user.get(0) : null;
	}
	
	public User findByEmail(String email) {
		String query = "select u from User u where email = '" + email + "'";

		List<User> user = entityManager.createQuery(query, User.class).getResultList();

		return user.size() == 1 ? user.get(0) : null;
	}

	public Iterable<User> findAll() {
		String query = "select u from User u";

		return entityManager.createQuery(query, User.class).getResultList();
	}
	
}
