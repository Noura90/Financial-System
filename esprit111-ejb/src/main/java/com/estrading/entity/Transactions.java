package com.estrading.entity;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Share
 *
 */
@Entity
@NamedQuery(name="retrieveByPTransactions", query ="select p from Transactions p ")
public class Transactions implements Serializable {

	
	private int idTransaction;
	private String typeTrans;
	private String name;
	private String DateTransaction;
	private Customer customer;
	
	
	
	
	private static final long serialVersionUID = 1L;
 
   
    public Transactions() {
		super();
	}   
    
    
    
   

	@Id
	@GeneratedValue
	public int getIdTransaction() {
		return this.idTransaction;
	}

	public void setIdTransaction(int idTransaction) {
		this.idTransaction = idTransaction;
	}





	public String getTypeTrans() {
		return typeTrans;
	}





	public void setTypeTrans(String typeTrans) {
		this.typeTrans = typeTrans;
	}





	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public String getDateTransaction() {
		return DateTransaction;
	}





	public void setDateTransaction(String dateTransaction) {
		DateTransaction = dateTransaction;
	}




	@ManyToOne
	public Customer getCustomer() {
		return customer;
	}





	public void setCustomer(Customer customer) {
		this.customer = customer;
	}   
	   
	
	
}
