package com.estrading.service;

import java.util.List;

import javax.ejb.Remote;

import com.estrading.entity.Bonds;


@Remote
public interface BondsServiceRemote {
	public  void insertBonds(Bonds bonds);
	public void updateBonds(Bonds bonds);
	public void deleteBonds(Bonds bonds);
	public Bonds getById(int id);
	public List<Bonds> getAll();
	public List<Bonds>  retrieveByPG(int id);
}