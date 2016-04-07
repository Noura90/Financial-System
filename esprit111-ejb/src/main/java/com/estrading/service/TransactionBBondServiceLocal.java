package com.estrading.service;

import java.util.List;

import javax.ejb.Local;

import com.estrading.entity.TransactionBBond;

@Local
public interface TransactionBBondServiceLocal {

	public  void inserttransactionBBond(TransactionBBond transactionBBond);
	public void updatetransactionBBond(TransactionBBond transactionBBond);
	public void deletetransactionBBond(TransactionBBond transactionBBond);
	public TransactionBBond getById(int id);
	public List<TransactionBBond> getAll();
}
