package tn.esprit.estrading.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.estrading.entity.Admin;
import com.estrading.service.AdminServiceLocal;



@ManagedBean(name = "adminController")
@ViewScoped
public class AdminController {

	@EJB
	AdminServiceLocal adminEjb;
	private List<Admin> admins;
	private boolean display = false;
	private Admin admin = new Admin();

	@PostConstruct
	private void init() {
		admins = adminEjb.getAll();
	}

	public String doUpdateAdmin() {
		adminEjb.updateadmin(getAdmin());
		display = false;
		return "AllAdmins?faces-redirect=true";
	}

	public String doCancelUpdateAdmin() {
		return "AllAdmins?faces-redirect=true";
	}

	public String doDeleteAdmin() {
		adminEjb.deleteAdmin(getAdmin());
		return "AllAdmins?faces-context=true";
	}

	public List<Admin> getAdmins() {
		return admins;
	}

	public int AdminNumber()
	{
		return admins.size();
	}
	public void setAdmins(List<Admin> admins) {
		this.admins = admins;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin Admin) {
		this.admin = Admin;
	}

	public boolean isDisplay() {
		return display;
	}

	public void setDisplay(boolean display) {
		this.display = display;
	}
	
}
