package com.estrading.service;

import com.estrading.entity.Admin;
import com.estrading.exception.BadCredentialException;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


/**
 * Session Bean implementation class ProfessionelService
 */
@Stateless
public class AdminService implements AdminServiceRemote, AdminServiceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager em;
    public AdminService() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public void insertAdmin(Admin admin) {
		// TODO Auto-generated method stub
		em.persist(admin);	}
	@Override
	public void updateadmin(Admin admin) {
		// TODO Auto-generated method stub
		em.merge(admin);
		
	}
	@Override
	public void deleteAdmin(Admin admin) {
		// TODO Auto-generated method stub
		em.remove(em.merge(admin));
	}
	@Override
	public Admin getById(int id) {
		// TODO Auto-generated method stub
		return em.find(Admin.class, id);
	}
	@SuppressWarnings("unchecked")
    @Override
	public List<Admin> getAll() {
		// TODO Auto-generated method stub
		javax.persistence.Query query = em.createQuery("select p from Admin p");
		return query.getResultList();
	}
	public Admin  retrieveByName(String nom) {
		// TODO Auto-generated method stub
		
		TypedQuery<Admin> query=em.createNamedQuery("retrieveByNameAdmin",Admin.class);
		query.setParameter("nom", nom);
		return query.getSingleResult();
	}


	@Override
	public Admin retrieveByNameuser(String nom) {
		// TODO Auto-generated method stub
		TypedQuery<Admin> query=em.createNamedQuery("retrieveByNameuserAdmin",Admin.class);
		query.setParameter("nom", nom);
		return query.getSingleResult();
	}
	
	@Override
	public Admin retrieveByCredentials(String username, String password) throws BadCredentialException {
		TypedQuery<Admin> query = em.createNamedQuery(
				"Admin.findByCredentials", Admin.class);
		query.setParameter("email", username);
		query.setParameter("password", password);
		try {
			return query.getSingleResult();
		} catch (NoResultException ex) {
			throw new BadCredentialException();
		}

	}
	
	@Override
	public List<Admin> retryByGmail(String gmail) {
	TypedQuery<Admin> query = em.createNamedQuery(
			"Admin.findAllByGmail", Admin.class);
	query.setParameter("gmail", gmail);
	return query.getResultList();
	}
	
	
	
	
}
