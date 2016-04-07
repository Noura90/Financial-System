package com.estrading.service;

import java.util.List;

import javax.ejb.Remote;

import com.estrading.entity.User;


@Remote
public interface UserServiceRemote {
	public void insertUser(User user);
	public void updateUser(User user);
	public void deleteProfessionel(User user);
	public User getById(int id);
	public List<User> getAll();
}
