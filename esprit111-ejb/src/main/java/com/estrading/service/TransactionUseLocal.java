package com.estrading.service;

import java.util.List;

import javax.ejb.Local;

import com.estrading.entity.Transactions;

@Local
public interface TransactionUseLocal {

	public void insertTransaction(Transactions transaction);
	public void updateTransaction(Transactions transaction);
	public void deleteTransaction(Transactions transaction);
	public Transactions getById(int id);
	public List<Transactions> getAll();
	public List<Transactions>  retrieveByPTransactions(int id);
	
}
