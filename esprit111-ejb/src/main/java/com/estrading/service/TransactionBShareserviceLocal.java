package com.estrading.service;

import java.util.List;

import javax.ejb.Local;

import com.estrading.entity.TransactionBShare;

@Local
public interface TransactionBShareserviceLocal {
	
	public void insertTransactionBShare(TransactionBShare transactionbshare);
	public void updateTransactionBShare(TransactionBShare transactionbshare);
	public void deleteTransactionBShare(TransactionBShare transactionbshare);
	public TransactionBShare getById(int id);
	public List<TransactionBShare> getAll();

}
