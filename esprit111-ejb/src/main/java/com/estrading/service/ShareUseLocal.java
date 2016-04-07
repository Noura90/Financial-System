package com.estrading.service;

import java.util.List;

import javax.ejb.Local;

import com.estrading.entity.Shares;

@Local
public interface ShareUseLocal {

	public void insertShare(Shares share);
	public void updateShare(Shares share);
	public void deleteShare(Shares share);
	public Shares getById(int id);
	public List<Shares> getAll();
	public List<Shares>  retrieveByP(int id);
	
}
