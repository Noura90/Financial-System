package com.estrading.service;

import java.util.List;

import javax.ejb.Local;

import com.estrading.entity.Bonds;

@Local
public interface BondsServiceLocal {
	public  void insertBonds(Bonds bonds);
	public void updateBonds(Bonds bonds);
	public void deleteBonds(Bonds bonds);
	public Bonds getById(int id);
	public List<Bonds> getAll();
	public List<Bonds>  retrieveByPG(int id);
}
