package com.estrading.service;

import java.util.List;

import javax.ejb.Local;

import com.estrading.entity.User;

@Local
public interface UserServiceLocal {
	public void insertUser(User user);
	public void updateUser(User user);
	public void deleteProfessionel(User user);
	public User getById(int id);
	public List<User> getAll();
}
