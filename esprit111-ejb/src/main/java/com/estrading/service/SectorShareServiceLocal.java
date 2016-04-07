
package com.estrading.service;


import java.util.List;

import javax.ejb.Local;

import com.estrading.entity.SectorShare;

@Local
public interface SectorShareServiceLocal {
	public void insertSectorShare(SectorShare sectorshare);
	public void updateSectorShare(SectorShare sectorshare);
	public void deleteSectorShare(SectorShare sectorshare);
	public SectorShare getById(int id);
	public List<SectorShare> getAll(); 

}