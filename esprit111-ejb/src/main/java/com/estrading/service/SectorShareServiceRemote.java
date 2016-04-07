 package com.estrading.service;

import java.util.List;

import javax.ejb.Remote;

import com.estrading.entity.SectorShare;

@Remote
public interface SectorShareServiceRemote {
	
	public void insertSectorShare(SectorShare sectorshare);
	public void updateSectorShare(SectorShare sectorshare);
	public void deleteSectorShare(SectorShare sectorshare);
	public SectorShare getById(int id);
	public List<SectorShare> getAll(); 

}