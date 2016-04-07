package com.estrading.service;

import java.util.List;

import javax.ejb.Local;

import com.estrading.entity.TransactionCustomer;

@Local
public interface TransactionCustomerServiceLocal {
	public void insertTransactionCustomer(TransactionCustomer transactionb);
	public void updateTransactionCustomer(TransactionCustomer transactionb);
	public void deleteTransactionCustomer(TransactionCustomer transactionb);
	public TransactionCustomer getById(int id);
	public List<TransactionCustomer> getAll();
	public List<TransactionCustomer>  retrieveByPT(int id);


}
