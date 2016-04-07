package com.estrading.service;

import java.util.List;

import javax.ejb.Remote;

import com.estrading.entity.SectorBond;



@Remote
public interface SectorBondServiceRemote {


	public void insertSectorBond(SectorBond sectorbond);
	public void updateSectorBond(SectorBond sectorbond);
	public void deleteSectorBond(SectorBond sectorbond);
	public SectorBond getById(int id);
	public List<SectorBond> getAll(); 
}
