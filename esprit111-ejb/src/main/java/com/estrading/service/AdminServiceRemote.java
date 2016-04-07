package com.estrading.service;

import java.util.List;

import javax.ejb.Remote;

import com.estrading.entity.Admin;

import com.estrading.exception.BadCredentialException;

@Remote
public interface AdminServiceRemote {
	public void insertAdmin(Admin professionel);
	public void updateadmin(Admin professionel);
	public void deleteAdmin(Admin professionel);
	public Admin getById(int id);
	public List<Admin> getAll();
	public Admin  retrieveByName(String nom);
	public Admin  retrieveByNameuser(String nom);
	public Admin retrieveByCredentials(String username, String password) throws BadCredentialException;
	public List<Admin> retryByGmail(String gmail);


}
