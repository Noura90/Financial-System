package com.estrading.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.estrading.entity.Transactions;



import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



/**
 * Session Bean implementation class TransactionUse
 */
@Stateless
@LocalBean
public class TransactionUse implements  TransactionUseLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager em;
    public TransactionUse() {
       
    }

	@Override
	public void insertTransaction(Transactions transaction) {
		em.merge(transaction);
		
	}

	@Override
	public void updateTransaction(Transactions transaction) {
		em.merge(transaction);
		
	}

	@Override
	public void deleteTransaction(Transactions transaction) {
		em.remove(em.merge(transaction));
		
	}

	@Override
	public Transactions getById(int id) {
		return em.find(Transactions.class, id);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Transactions> getAll() {
		javax.persistence.Query query = em.createQuery("select e from Transactions e");
		return query.getResultList();
	}
	public List<Transactions>  retrieveByPTransactions(int id) {
		TypedQuery<Transactions> query=em.createNamedQuery("retrieveByPPTransactions",Transactions  .class);
		query.setParameter("nom", id);
		return query.getResultList();
	}
	
	
	
}

