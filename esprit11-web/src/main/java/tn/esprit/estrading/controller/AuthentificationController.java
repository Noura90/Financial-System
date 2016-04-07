package tn.esprit.estrading.controller;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.estrading.entity.Customer;
import com.estrading.exception.BadCredentialException;
import com.estrading.service.CustomerServiceLocal;

import controller.MyShareController;


@ManagedBean(name = "authenticationController" , eager = false)
@SessionScoped
public class AuthentificationController {

	@EJB
	CustomerServiceLocal customerEJB;
	
	
	private boolean loggedIn = false;
	private Customer customer = new Customer();
	
private int message = customer.getId_user();
	
	public int getMessage() {
        return message;
    }
    public void setMessage(int message) {
        this.message = message;
    }
	

	public String doLogIn() {
		try {
			customer = customerEJB.retrieveByCredentials(customer.getEmail_user(), customer.getPassword_user());
			loggedIn = true;
			message = customer.getId_user();
			return "index?faces-redirect=true";
		} catch (BadCredentialException ex) {
			FacesContext.getCurrentInstance().addMessage("formLogin:authFormMsg",new FacesMessage("Bad Credentials", "Please fill in good ones"));
			return null;
		}
	}

	public String doLogOut() {
		
		customer = new Customer();
		loggedIn = false;

		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "login2?faces-redirect=true";
	}
	
	
	public void updateProfileCustomer(){
		try{
		 
		Customer customerUpdate=customer;
		customerEJB.updatecustomer(customerUpdate);
		FacesContext.getCurrentInstance().
		addMessage("updateprofile:updateFormMsg",new FacesMessage("success!!", "Profile updated"));
			
		
		}catch(Exception ex){
			
			FacesContext.getCurrentInstance().
			addMessage("updateprofile:updateFormMsg",new FacesMessage("Failed!!", "Profile not updated"));	
		}
	}
	
	

	/**
	 * variable booleenne verifiable
	 * @isLoggedIn
	 */

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	
	
}
