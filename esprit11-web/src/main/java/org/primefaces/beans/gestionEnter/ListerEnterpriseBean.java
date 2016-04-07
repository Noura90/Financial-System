package org.primefaces.beans.gestionEnter;

import java.util.List;

import javax.ejb.EJB;

import com.esprit.entity.Enterprise;
import com.esprit.service.gestionEnterprise.GestionEnterpriseLocal;

public class ListerEnterpriseBean {
	@EJB
	GestionEnterpriseLocal bean;
	List<String> enterprises;
	List<Enterprise> listeEnterprises;
	List<Enterprise> listeParMat;
	Enterprise enterprise;
	private Enterprise selectedEnterprise;
	private String MatEnterprise;

	public List<String> getEnterprises() {
		enterprises = bean.findAllEnterprise();

		return enterprises;
	}

	public void setEnterprises(List<String> enterprises) {
		this.enterprises = enterprises;
	}

	public List<Enterprise> getListeEnterprises() {
		listeEnterprises = bean.findAll();
		return listeEnterprises;
	}

	public void setListeEnterprises(List<Enterprise> listeEnterprises) {
		this.listeEnterprises = listeEnterprises;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public Enterprise getSelectedEnterprise() {
		return selectedEnterprise;
	}

	public void setSelectedEnterprise(Enterprise selectedEnterprise) {
		this.selectedEnterprise = selectedEnterprise;
	}

	public void delete() {
		bean.removeEnterprise(selectedEnterprise);
	}

	public List<Enterprise> getListeParMat() {
		listeParMat=bean
				.findAllByMat(getMatEnterprise());
		return listeParMat;
	}

	public void setListeParMat(List<Enterprise> listeParMat) {
		this.listeParMat = listeParMat;
	}

	public String getMatEnterprise() {
		return MatEnterprise;
	}

	public void setMatEnterprise(String matEnterprise) {
		MatEnterprise = matEnterprise;
	}
	
	
	
	

}
