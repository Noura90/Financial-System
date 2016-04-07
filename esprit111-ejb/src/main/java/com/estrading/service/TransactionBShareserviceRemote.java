package com.estrading.service;

import java.util.List;

import javax.ejb.Remote;

import com.estrading.entity.TransactionBShare;


@Remote
public interface TransactionBShareserviceRemote {
	public void insertTransactionBShare(TransactionBShare transactionbshare);
	public void updateTransactionBShare(TransactionBShare transactionbshare);
	public void deleteTransactionBShare(TransactionBShare transactionbshare);
	public TransactionBShare getById(int id);
	public List<TransactionBShare> getAll();
}
