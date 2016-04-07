package org.primefaces.beans.gestionSector;

import java.util.List;

import javax.ejb.EJB;

import com.esprit.entity.Sector;
import com.esprit.service.gestionSector.GestionSectorLocal;

public class ListerSectorBean {
	@EJB
	GestionSectorLocal bean;
	List<String> sectors;
	List<Sector> listeSectors;
	Sector sector;
	private Sector selectedSector;

	public List<String> getSectors() {
		sectors=bean.findAllSector();
		return sectors;
	}

	public void setSectors(List<String> sectors) {
		this.sectors = sectors;
	}

	public List<Sector> getListeSectors() {
		listeSectors = bean.findAll();
		return listeSectors;
	}

	public void setListeSectors(List<Sector> listeSectors) {
		this.listeSectors = listeSectors;
	}

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	public Sector getSelectedSector() {
		return selectedSector;
	}

	public void setSelectedSector(Sector selectedSector) {
		this.selectedSector = selectedSector;
	}

	public void delete() {
		bean.removeSector(selectedSector);
	}

}
