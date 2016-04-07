package com.estrading.entity;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Admin
 * 
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NamedQueries({
		@NamedQuery(name = "retrieveByNameAdmin", query = "select p from Admin p where p.login_user= :nom"),
		@NamedQuery(name = "retrieveByNameuserAdmin", query = "select p from Admin p where p.name_user= :nom"),
		@NamedQuery(name = "Admin.findAllByGmail", query = "select t from Admin t where t.email_user =:gmail"),
		@NamedQuery(name = "Admin.findByCredentials", query = "select t from Admin t where t.email_user =:email AND t.password_user =:password") })
public class Admin extends User implements Serializable {

	
	private int Id_admin;
	private String address_admin;
	private static final long serialVersionUID = 1L;
	

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Admin() {
		super();
	}



	@Column(name = "Id_admin")
	public int getId_Admin() {
		return this.Id_admin;
	}

	public void setId_Admin(int Id_admin) {
		this.Id_admin = Id_admin;
	}

	@Column(name = "address_admin")
	public String getAddress_Admin() {
		return this.address_admin;
	}

	public void setAddress_Admin(String address_admin) {
		this.address_admin = address_admin;
	}




	

}
