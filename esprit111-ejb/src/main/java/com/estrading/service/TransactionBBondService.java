package com.estrading.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.estrading.entity.TransactionBBond;

/**
 * Session Bean implementation class transactionBBondService
 */
@Stateless
@LocalBean
public class TransactionBBondService implements TransactionBBondServiceRemote, TransactionBBondServiceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager entityManager;
    public TransactionBBondService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void inserttransactionBBond(TransactionBBond transactionBBond) {
		// TODO Auto-generated method stub
		entityManager.persist(transactionBBond);
		
	}

	@Override
	public void updatetransactionBBond(TransactionBBond transactionBBond) {
		// TODO Auto-generated method stub
		entityManager.merge(transactionBBond);
	}

	@Override
	public void deletetransactionBBond(TransactionBBond transactionBBond) {
		// TODO Auto-generated method stub
		entityManager.remove(entityManager.merge(transactionBBond));
		
	}

	@Override
	public TransactionBBond getById(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(TransactionBBond.class, id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<TransactionBBond> getAll() {
		// TODO Auto-generated method stub
		javax.persistence.Query query = entityManager.createQuery("select t from transactionBBond t");
		return query.getResultList();
	}

}
