package tn.esprit.estrading.controller.admin;


import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.estrading.entity.Admin;
import com.estrading.service.AdminServiceLocal;

@ManagedBean(name="registrationControllerAdmin")
@ViewScoped
public class RegistrationControllerAdmin {
	
	
		
		@EJB
		AdminServiceLocal adminEjb; 
		private Admin admin = new Admin();
		
		public String doRegisterAdmin(){
//			
//			adminEjb.insertAdmin(customer);
//			
//			return "login2?faces-redirect=true"
			
			if(adminEjb.retryByGmail(admin.getEmail_user()).size()==0){
				adminEjb.insertAdmin(admin);
				
				return "loginAdmin?faces-redirect=true";
			}
			else 
				{			
					
					FacesContext.getCurrentInstance().addMessage("registrationForm:regisFormMsg",new FacesMessage("erreur:", "invalide mail"));
				return  "null";
				}
			
				
		}
		
		public String doRegisterAdmin1(){
//			
//			adminEjb.insertAdmin(customer);
//			
//			return "login2?faces-redirect=true"
			
			if(adminEjb.retryByGmail(admin.getEmail_user()).size()==0){
				adminEjb.insertAdmin(admin);
				
				return "loginAdmin?faces-redirect=true";
			}
			else 
				{			
					
					FacesContext.getCurrentInstance().addMessage("registrationForm:regisFormMsg",new FacesMessage("erreur:", "invalide mail"));
				return  "null";
				}
			
				
		}

		public Admin getAdmin() {
			return admin;
		}

		public void setAdmin(Admin admin) {
			this.admin = admin;
		}
}
