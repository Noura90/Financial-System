package org.primefaces.beans.gestionEnter;

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

public class EnterBean {
	@EJB
	GestionEnterpriseLocal bean;

	@EJB
	GestionSectorLocal beanSector;

	List<Enterprise> enterprises;
	Enterprise enterprise;
	String login;
	String password;
	String label = "Choisir";

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setEnterprises(List<Enterprise> Enterprises) {
		this.enterprises = Enterprises;
	}

	public Enterprise getEnterprise() {
		if (enterprise == null) {
			enterprise = new Enterprise();
		}

		return enterprise;
	}

	public void setEnterprise(Enterprise Enterprise) {
		this.enterprise = Enterprise;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String validate() throws Exception {
		try {
			@SuppressWarnings("unused")
			Enterprise user = bean.findByUser(getLogin(), getPassword());
		} catch (Exception e) {
			return "auth";
		}

		return "main";

	}

	public void doAddEnterprise() {

		bean.save(enterprise);
	}

	// public void addAffectationSector() {
	// Sector p = beanSector.findByLibelleSector(label);
	// System.out.println(p);
	// Enterprise.setSector(p);
	//
	// bean.update(Enterprise);
	// Enterprise = new Enterprise();
	// label = "Choisir";
	//
	// }

	// ************************** ancien *************************************

	private String libelleSector;

	private List<SelectItem> enterprisesElements;

	private String nomEnterprise;

	private DataModel dataModel = new ListDataModel();

	@EJB
	private GestionSectorLocal gestionSectorLocal;
	@EJB
	private GestionEnterpriseLocal gestionEnterpriseLocal;

	public void init() {
		Enterprise enterprise = new Enterprise();

	}

	public List<SelectItem> getEnterprisesElements() {

		List<Enterprise> enterprises = gestionEnterpriseLocal.findAll();
		// enterprisesElements=new ArrayList<SelectItem>(enterprises.size()+1);

		if (enterprisesElements == null) {
			enterprisesElements = new ArrayList<SelectItem>();
			for (Enterprise F : enterprises) {
				enterprisesElements.add(new SelectItem(F.getMatriculeEnterprise(), F.getNom()));
			}
		}

		return enterprisesElements;
	}

	public void setEnterprisesElements(List<SelectItem> enterprisesElements) {
		this.enterprisesElements = enterprisesElements;
	}

	public String getNomEnterprise() {
		return nomEnterprise;
	}

	public void setNomEnterprise(String nomEnterprise) {
		this.nomEnterprise = nomEnterprise;
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

		List<Sector> listeSectors;
		listeSectors = gestionSectorLocal.findByLibelle(getLibelleSector());
//		enterprise.setSector(listeSectors.get(0));
		enterprise.setNom(getNomEnterprise());
		gestionEnterpriseLocal.save(enterprise);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"add with success profile : ", enterprise.getNom()));
		reset();

	}

	// ------------------------------Mise a jour affectation
	// ---------------------------------
	public String update() {
		enterprise = (Enterprise) dataModel.getRowData();
		gestionEnterpriseLocal.update(enterprise);
		return "updateEnterprise";
	}

	// -------------------------------Supression affectation
	// ---------------------------------
	public String delete() {
		enterprise = (Enterprise) dataModel.getRowData();
		gestionEnterpriseLocal.deleteByMat(enterprise.getMatriculeEnterprise());
		return "deleteEnterprise";

	}

	// -------------------------------Mise a jour affectation
	// --------------------------------
	public void updateEnterprise(ActionEvent actionEvent) {

		gestionEnterpriseLocal.update(enterprise);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("update with success !!! "));

	}

	// -------------------------------Supression affectation
	// ---------------------------------

	

	public void reset() {
		setNomEnterprise(null);
	}

	public String getLibelleSector() {
		return libelleSector;
	}

	public void setLibelleSector(String libelleSector) {
		this.libelleSector = libelleSector;
	}

}
