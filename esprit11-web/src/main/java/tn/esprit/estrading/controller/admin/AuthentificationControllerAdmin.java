package tn.esprit.estrading.controller.admin;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.estrading.entity.Admin;
import com.estrading.exception.BadCredentialException;
import com.estrading.service.AdminServiceLocal;

import controller.MyShareController;


@ManagedBean(name = "authenticationControllerAdmin" , eager = false)
@SessionScoped
public class AuthentificationControllerAdmin {

	@EJB
	AdminServiceLocal adminEJB;
	
	
	private boolean loggedIn = false;
	private Admin admin = new Admin();
	
private int message = admin.getId_user();
	
	public int getMessage() {
        return message;
    }
    public void setMessage(int message) {
        this.message = message;
    }
	

	public String doLogIn() {
		try {
			admin = adminEJB.retrieveByCredentials(admin.getEmail_user(), admin.getPassword_user());
			loggedIn = true;
			message = admin.getId_user();
			return "indexAdmin?faces-redirect=true";
		} catch (BadCredentialException ex) {
			FacesContext.getCurrentInstance().addMessage("formLogin:authFormMsg",new FacesMessage("Bad Credentials", "Please fill in good ones"));
			return null;
		}
	}

	public String doLogOut() {
		
		admin = new Admin();
		loggedIn = false;

		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "loginAdmin?faces-redirect=true";
	}
	
	
	public void updateProfileAdmin(){
		try{
		 
		Admin adminUpdate=admin;
		adminEJB.updateadmin(adminUpdate);
		FacesContext.getCurrentInstance().
		addMessage("updateprofile:updateFormMsg",new FacesMessage("success!!", "Profile updated"));
			
		
		}catch(Exception ex){
			
			FacesContext.getCurrentInstance().
			addMessage("updateprofile:updateFormMsg",new FacesMessage("Failed!!", "Profile not updated"));	
		}
	}
	
	

	

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	
	
	
}
