package tn.esprit.estrading.controller;


import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.estrading.entity.Customer;
import com.estrading.service.CustomerServiceLocal;

@ManagedBean(name="registrationController")
@ViewScoped
public class RegistrationController {
	
	
		
		@EJB
		CustomerServiceLocal customerEjb; 
		private Customer customer = new Customer();
		
		public String doRegisterCustomer(){
//			customer.setNbre_capital_P(100);
//			customerEjb.insertCustomer(customer);
//			
//			return "login2?faces-redirect=true"
			
			if(customerEjb.retryByGmail(customer.getEmail_user()).size()==0){
				customer.setNbre_capital_P(10000);
				customerEjb.insertCustomer(customer);
				
				return "login2?faces-redirect=true";
			}
			else 
				{			
					
					FacesContext.getCurrentInstance().addMessage("registrationForm:regisFormMsg",new FacesMessage("erreur:", "invalide mail"));
				return  "null";
				}
			
				
		}

		public String doRegisterCustomer1(){
//			customer.setNbre_capital_P(100);
//			customerEjb.insertCustomer(customer);
//			
//			return "login2?faces-redirect=true"
			
			if(customerEjb.retryByGmail(customer.getEmail_user()).size()==0){
				customer.setNbre_capital_P(10000);
				customerEjb.insertCustomer(customer);
				
				return "indexAdmin?faces-redirect=true";
			}
			else 
				{			
					
					FacesContext.getCurrentInstance().addMessage("registrationForm:regisFormMsg",new FacesMessage("erreur:", "invalide mail"));
				return  "null";
				}
			
				
		}
		
		
		
		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}
}
