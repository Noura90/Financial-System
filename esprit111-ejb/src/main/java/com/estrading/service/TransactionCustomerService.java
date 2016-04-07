package com.estrading.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.estrading.entity.TransactionCustomer;

/**
 * Session Bean implementation class TransactionBService
 */
@Stateless
@LocalBean
public class TransactionCustomerService implements TransactionCustomerServiceRemote, TransactionCustomerServiceLocal {

    /**
     * Default constructor. 
     */
@PersistenceContext
 EntityManager em;
    public TransactionCustomerService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void insertTransactionCustomer(TransactionCustomer transactioncustomer) {
		// TODO Auto-generated method stub
		em.persist(transactioncustomer);
	}

	@Override
	public void updateTransactionCustomer(TransactionCustomer transactioncustomer) {
		// TODO Auto-generated method stub
		em.merge(transactioncustomer);
	}

	@Override
	public void deleteTransactionCustomer(TransactionCustomer transactioncustomer) {
		// TODO Auto-generated method stub
		em.remove(em.merge(transactioncustomer));
	}

	@Override
	public TransactionCustomer getById(int id) {
		// TODO Auto-generated method stub
		return em.find(TransactionCustomer.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TransactionCustomer> getAll() {
		// TODO Auto-generated method stub
		javax.persistence.Query query = em.createQuery("select b from TransactionCustomer b");
		return query.getResultList();
	}

	public List<TransactionCustomer>  retrieveByPT(int id) {
		// TODO Auto-generated method stub
		
		
		TypedQuery<TransactionCustomer> query=em.createNamedQuery("retrieveByPT",TransactionCustomer .class);
		query.setParameter("nom", id);
		return query.getResultList();
	}
}
