package com.estrading.service;

import java.util.List;

import javax.ejb.Remote;

import com.estrading.entity.TransactionCustomer;

@Remote
public interface TransactionCustomerServiceRemote {
	public void insertTransactionCustomer(TransactionCustomer transactionb);
	public void updateTransactionCustomer(TransactionCustomer transactionb);
	public void deleteTransactionCustomer(TransactionCustomer transactionb);
	public TransactionCustomer getById(int id);
	public List<TransactionCustomer> getAll();
	public List<TransactionCustomer>  retrieveByPT(int id);

}
