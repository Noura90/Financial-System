package com.estrading.service;

import com.estrading.entity.Customer;
import com.estrading.exception.BadCredentialException;

import java.util.List;

import javax.ejb.Local;

@Local
public interface CustomerServiceLocal {
	public void insertCustomer(Customer professionel);
	public void updatecustomer(Customer professionel);
	public void deleteCustomer(Customer professionel);
	public Customer getById(int id);
	public List<Customer> getAll();
	public Customer  retrieveByName(String nom);
	public Customer  retrieveByNameuser(String nom);
	public Customer retrieveByCredentials(String username, String password) throws BadCredentialException;
	public List<Customer> retryByGmail(String gmail);
}
