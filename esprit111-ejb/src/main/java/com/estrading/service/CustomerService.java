package com.estrading.service;

import com.estrading.entity.Customer;
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
public class CustomerService implements CustomerServiceRemote, CustomerServiceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager em;
    public CustomerService() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public void insertCustomer(Customer customer) {
		// TODO Auto-generated method stub
		em.persist(customer);	}
	@Override
	public void updatecustomer(Customer customer) {
		// TODO Auto-generated method stub
		em.merge(customer);
		
	}
	@Override
	public void deleteCustomer(Customer customer) {
		// TODO Auto-generated method stub
		em.remove(em.merge(customer));
	}
	@Override
	public Customer getById(int id) {
		// TODO Auto-generated method stub
		return em.find(Customer.class, id);
	}
	@SuppressWarnings("unchecked")
    @Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		javax.persistence.Query query = em.createQuery("select p from Customer p");
		return query.getResultList();
	}
	public Customer  retrieveByName(String nom) {
		// TODO Auto-generated method stub
		
		TypedQuery<Customer  > query=em.createNamedQuery("retrieveByName",Customer.class);
		query.setParameter("nom", nom);
		return query.getSingleResult();
	}


	@Override
	public Customer retrieveByNameuser(String nom) {
		// TODO Auto-generated method stub
		TypedQuery<Customer> query=em.createNamedQuery("retrieveByNameuser",Customer.class);
		query.setParameter("nom", nom);
		return query.getSingleResult();
	}
	
	@Override
	public Customer retrieveByCredentials(String username, String password) throws BadCredentialException {
		TypedQuery<Customer> query = em.createNamedQuery(
				"Customer.findByCredentials", Customer.class);
		query.setParameter("email", username);
		query.setParameter("password", password);
		try {
			return query.getSingleResult();
		} catch (NoResultException ex) {
			throw new BadCredentialException();
		}

	}
	
	@Override
	public List<Customer> retryByGmail(String gmail) {
	TypedQuery<Customer> query = em.createNamedQuery(
			"Customer.findAllByGmail", Customer.class);
	query.setParameter("gmail", gmail);
	return query.getResultList();
	}
	
	
	
	
}
