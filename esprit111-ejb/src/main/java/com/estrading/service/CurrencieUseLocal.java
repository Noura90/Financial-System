package com.estrading.service;

import java.util.List;

import javax.ejb.Local;

import com.estrading.entity.Currencies;

@Local
public interface CurrencieUseLocal {

	public void insertCurrencie(Currencies currencie);
	public void updateCurrencie(Currencies currencie);
	public void deleteCurrencie(Currencies currencie);
	public Currencies getById(int id);
	public List<Currencies> getAll();
	public List<Currencies>  retrieveByPCurrencies(int id);
	
}
