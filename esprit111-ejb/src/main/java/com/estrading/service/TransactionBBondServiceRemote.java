package com.estrading.service;

import java.util.List;

import javax.ejb.Remote;

import com.estrading.entity.TransactionBBond;

@Remote
public interface TransactionBBondServiceRemote {
	public  void inserttransactionBBond(TransactionBBond transactionBBond);
	public void updatetransactionBBond(TransactionBBond transactionBBond);
	public void deletetransactionBBond(TransactionBBond transactionBBond);
	public TransactionBBond getById(int id);
	public List<TransactionBBond> getAll();

}
