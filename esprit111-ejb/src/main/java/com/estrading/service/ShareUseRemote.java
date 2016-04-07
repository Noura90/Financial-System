package com.estrading.service;

import java.util.List;

import javax.ejb.Remote;

import com.estrading.entity.Shares;

@Remote
public interface ShareUseRemote {
	
	public void insertShare(Shares share);
	public void updateShare(Shares share);
	public void deleteShare(Shares share);
	public Shares getById(int id);
	public List<Shares> getAll();
	public List<Shares>  retrieveByP(int id);
}
