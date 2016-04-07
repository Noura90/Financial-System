package tn.esprit.estrading.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.estrading.entity.Customer;
import com.estrading.service.CustomerServiceLocal;



@ManagedBean(name = "customerController")
@ViewScoped
public class CustomerController {

	@EJB
	CustomerServiceLocal customerEjb;
	private List<Customer> customers;
	private boolean display = false;
	private Customer customer = new Customer();

	@PostConstruct
	private void init() {
		customers = customerEjb.getAll();
	}

	public String doUpdateCustomer() {
		customerEjb.updatecustomer(getCustomer());
		display = false;
		return "AllCustomers?faces-redirect=true";
	}

	public String doCancelUpdateCustomer() {
		return "AllCustomers?faces-redirect=true";
	}

	public String doDeleteCustomer() {
		customerEjb.deleteCustomer(getCustomer());
		return "AllCustomers?faces-context=true";
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public int CustomerNumber()
	{
		return customers.size();
	}
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer Customer) {
		this.customer = Customer;
	}

	public boolean isDisplay() {
		return display;
	}

	public void setDisplay(boolean display) {
		this.display = display;
	}
	
}
