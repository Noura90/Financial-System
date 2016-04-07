package com.estrading.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.estrading.entity.TransactionBShare;



/**
 * Session Bean implementation class TransactionBShare
 */
@Stateless
@LocalBean
public class TransactionBSharesevice implements TransactionBShareserviceRemote, TransactionBShareserviceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	 EntityManager em;
    public TransactionBSharesevice() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public void insertTransactionBShare(TransactionBShare transactionbshare) {
		// TODO Auto-generated method stub
		em.persist(transactionbshare);
		
	}
	@Override
	public void updateTransactionBShare(TransactionBShare transactionbshare) {
		// TODO Auto-generated method stub
		em.merge(transactionbshare);
		
	}
	@Override
	public void deleteTransactionBShare(TransactionBShare transactionbshare) {
		// TODO Auto-generated method stub
		em.remove(em.merge(transactionbshare));
		
	}
	@Override
	public com.estrading.entity.TransactionBShare getById(int id) {
		// TODO Auto-generated method stub
		return em.find(com.estrading.entity.TransactionBShare.class, id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<com.estrading.entity.TransactionBShare> getAll() {
		// TODO Auto-generated method stub
		javax.persistence.Query query = em.createQuery("select t from TransactionBShare t");
		return query.getResultList();
	}



}
