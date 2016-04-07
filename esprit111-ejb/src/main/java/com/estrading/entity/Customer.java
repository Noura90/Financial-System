package com.estrading.entity;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Customer
 * 
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NamedQueries({
		@NamedQuery(name = "retrieveByName", query = "select p from Customer p where p.login_user= :nom"),
		@NamedQuery(name = "retrieveByNameuser", query = "select p from Customer p where p.name_user= :nom"),
		@NamedQuery(name = "Customer.findAllByGmail", query = "select t from Customer t where t.email_user =:gmail"),
		@NamedQuery(name = "Customer.findByCredentials", query = "select t from Customer t where t.email_user =:email AND t.password_user =:password") })
public class Customer extends User implements Serializable {

	private int Nbre_capital_C;
	private int Id_customer;
	private String address_cust;
	private static final long serialVersionUID = 1L;
	private int liquidity;

	private List<TransactionCustomer> listofTransaction;
	private List<Transactions> listofTransactions;
	
	private List<Shares> listofshares;
	private List<Bonds> listofbond;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.REFRESH)
	public List<TransactionCustomer> getListofTransaction() {
		return listofTransaction;
	}
	
	

	public void setListofTransaction(List<TransactionCustomer> listofTransaction) {
		this.listofTransaction = listofTransaction;
	}
	
	
	

	
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Customer() {
		super();
	}
	
	/**
	 * le capital de client
	 * @author Chams
	 * @return Nbre_capital_C
	 */

	public int getNbre_capital_P() {
		return this.Nbre_capital_C;
	}

	public void setNbre_capital_P(int Nbre_capital_P) {
		this.Nbre_capital_C = Nbre_capital_P;
	}

	@Column(name = "Id_customer")
	public int getId_Customer() {
		return this.Id_customer;
	}

	public void setId_Customer(int Id_customer) {
		this.Id_customer = Id_customer;
	}

	@Column(name = "address_cust")
	public String getAddress_Customer() {
		return this.address_cust;
	}

	public void setAddress_Customer(String address_cus) {
		this.address_cust = address_cus;
	}

	public void assignTransactiontothisCustomer(
			List<TransactionCustomer> transactionBs) {
		this.setListofTransaction(listofTransaction);
		for (TransactionCustomer e : transactionBs) {
			e.setCustomer(this);
		}
	}

	@OneToMany(mappedBy = "customer", cascade = CascadeType.REFRESH)
	public List<Shares> getListofshares() {
		return listofshares;
	}

	public void setListofshares(List<Shares> listofshares) {
		this.listofshares = listofshares;
	}

	@OneToMany(mappedBy = "professionel", cascade = CascadeType.REFRESH)
	public List<Bonds> getListofbond() {
		return listofbond;
	}

	public void setListofbond(List<Bonds> listofbond) {
		this.listofbond = listofbond;
	}

	/**
	 * la liquidité d'une action 
	 * @author Chams
	 * @return liquidity
	 */
	public int getLiquidity() {
		return liquidity;
	}

	public void setLiquidity(int liquidity) {
		this.liquidity = liquidity;
	}


	@OneToMany(mappedBy = "customer", cascade = CascadeType.REFRESH)
	public List<Transactions> getListofTransactions() {
		return listofTransactions;
	}



	public void setListofTransactions(List<Transactions> listofTransactions) {
		this.listofTransactions = listofTransactions;
	}



	

}
