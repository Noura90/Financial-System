package com.estrading.entity;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity

public class User implements Serializable {

	
	private int Id_user;
	private String Name_user;
	private String Email_user;
	private Integer Telephone_user;
	private String Login_user;
	private String Password_user;
	private Date birthday;
	
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}   
	@Id    
	@GeneratedValue(strategy=GenerationType.IDENTITY) 

	public int getId_user() {
		return this.Id_user;
	}

	public void setId_user(int Id_user) {
		this.Id_user = Id_user;
	}   
	public String getName_user() {
		return this.Name_user;
	}

	public void setName_user(String Name_user) {
		this.Name_user = Name_user;
	}   
	public String getEmail_user() {
		return this.Email_user;
	}

	public void setEmail_user(String Email_user) {
		this.Email_user = Email_user;
	}   
	public Integer getTelephone_user() {
		return this.Telephone_user;
	}

	public void setTelephone_user(Integer Telephone_user) {
		this.Telephone_user = Telephone_user;
	}   
	public String getLogin_user() {
		return this.Login_user;
	}

	public void setLogin_user(String Login_user) {
		this.Login_user = Login_user;
	}   
	public String getPassword_user() {
		return this.Password_user;
	}

	public void setPassword_user(String Password_user) {
		this.Password_user = Password_user;
	}
   
}
