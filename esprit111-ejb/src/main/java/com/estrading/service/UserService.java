package com.estrading.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.estrading.entity.User;

/**
 * Session Bean implementation class UserService
 */
@Stateless
@LocalBean
public class UserService implements UserServiceRemote, UserServiceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager em;
    public UserService() {

    }

	@Override
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		em.persist(user);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		em.merge(user);
	}

	@Override
	public void deleteProfessionel(User user) {
		// TODO Auto-generated method stub
		em.remove(em.merge(user));
	}

	@Override
	public User getById(int id) {
		// TODO Auto-generated method stub
		return 	em.find(User.class, id);

	}
@SuppressWarnings("unchecked")
@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		javax.persistence.Query query = em.createQuery("select u from User u");
		return query.getResultList();
	}


}
