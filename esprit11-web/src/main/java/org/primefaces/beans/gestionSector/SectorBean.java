package org.primefaces.beans.gestionSector;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

import com.esprit.entity.Enterprise;
import com.esprit.entity.Sector;
import com.esprit.service.gestionEnterprise.GestionEnterpriseLocal;
import com.esprit.service.gestionSector.GestionSectorLocal;

public class SectorBean {
	@EJB
	GestionSectorLocal bean;

	List<Sector> sectors;
	Sector sector;

	String label = "Choisir";

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setSectors(List<Sector> Sectors) {
		this.sectors = Sectors;
	}

	public Sector getSector() {
		if (sector == null) {
			sector = new Sector();
		}

		return sector;
	}

	public void setSector(Sector Sector) {
		this.sector = Sector;
	}

	public List<Sector> getSectors() {
		return sectors;
	}

	public void doAddSector() {

		bean.save(sector);

	}

	// *********************************** affectation
	// ***********************************

	private List<SelectItem> SectorsElements;

	private String libelleSector;

	private String description;

	private String etatSector;

	private String nomEnseignant;

	private DataModel dataModel = new ListDataModel();

	@EJB
	private GestionSectorLocal gestionSectorLocal;
	@EJB
	private GestionEnterpriseLocal gestionEnseignantLocal;

	public void init() {
		Sector sector = new Sector();

	}

	public List<SelectItem> getSectorsElements() {

		List<Sector> sectors = gestionSectorLocal.findAll();

		// SectorsElements=new ArrayList<SelectItem>(sectors.size()+1);

		if (SectorsElements == null) {
			SectorsElements = new ArrayList<SelectItem>();
			for (Sector F : sectors) {
				SectorsElements.add(new SelectItem(F.getRefSector(), F
						.getLibelleSector()));
			}
		}

		return SectorsElements;
	}

	public void setSectorsElements(List<SelectItem> sectorsElements) {
		this.SectorsElements = sectorsElements;
	}

	public String getLibelleSector() {
		return libelleSector;
	}

	public void setLibelleSector(String libelleSector) {
		this.libelleSector = libelleSector;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEtatSector() {
		return etatSector;
	}

	public void setEtatSector(String etatSector) {
		this.etatSector = etatSector;
	}

	public String getNomEnseignant() {
		return nomEnseignant;
	}

	public void setNomEnseignant(String nomEnseignant) {
		this.nomEnseignant = nomEnseignant;
	}

	public DataModel getDataModel() {
		dataModel.setWrappedData(gestionSectorLocal.findAll());

		return dataModel;
	}

	public void setDataModel(DataModel dataModel) {
		this.dataModel = dataModel;
	}

	// -------------------------------Ajouter une nouvelle affectation
	// -------------------------------------

	public void add(ActionEvent actionEvent) {

		sector.setLibelleSector(getLibelleSector());
		sector.setDescription(getDescription());
		gestionSectorLocal.save(sector);

		FacesContext.getCurrentInstance()
				.addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"add with success Sector : ", sector
										.getLibelleSector()));

		reset();

	}

	// ------------------------------Mise a jour affectation
	// ---------------------------------
	public String update() {
		sector = (Sector) dataModel.getRowData();
		gestionSectorLocal.update(sector);
		return "updateSector";
	}

	// -------------------------------Supression affectation
	// ---------------------------------
	public String delete() {
		sector = (Sector) dataModel.getRowData();
		gestionSectorLocal.deleteByRef(sector.getRefSector());
		return "deleteSector";

	}

	// -------------------------------Mise a jour affectation
	// --------------------------------
	public void updateSector(ActionEvent actionEvent) {

		gestionSectorLocal.update(sector);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("update with success !!! "));

	}

	// -------------------------------Supression affectation
	// ---------------------------------

	public void deleteSector(ActionEvent actionEvent) {
		gestionSectorLocal.delete(sector);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Delete with success !!! "));
	}

	public void reset() {
		setLibelleSector(null);
		setDescription(null);
	}

}
